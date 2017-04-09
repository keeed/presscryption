/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.views.medicinemanagement;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import presscryption.client.constants.UIPropertiesKey;
import presscryption.client.javafx.views.BaseViewController;
import presscryption.client.models.Medicine;
import presscryption.client.models.Medicines;
import presscryption.client.presenters.ManageMedicinesPresenter;
import presscryption.client.viewdefinitions.IManageMedicinesView;
import presscryption.common.ComponentManager;
import presscryption.common.PropertiesManager;
import presscryption.medicinemanagement.contract.services.IMedicineManagementService;
import presscryption.servicemodels.IMedicineServiceModel;
import presscryption.servicemodels.MedicineServiceModel;

/**
 * FXML Controller class
 *
 * @author Kedren Villena
 */
public class ManageMedicinesViewController extends BaseViewController implements Initializable, IManageMedicinesView {

    private ManageMedicinesPresenter _manageMedicinesPresenter;

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    @FXML
    private TextField genericNameTextField;
    @FXML
    private TextField brandNameTextField;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Medicine> medicineTable;
    @FXML
    private TableColumn<Medicine, String> genericNameColumn;
    @FXML
    private TableColumn<Medicine, String> brandNameColumn;
    @FXML
    private TableColumn<Medicine, String> dateAddedColumn;

    private IMedicineServiceModel medicineServiceModel;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        genericNameColumn.setCellValueFactory(cellData -> cellData.getValue().getGenericName());
        brandNameColumn.setCellValueFactory(cellData -> cellData.getValue().getBrandName());
        dateAddedColumn.setCellValueFactory(
                cellData -> new SimpleStringProperty(
                        dateTimeFormatter.format(cellData.getValue().getDateCreated().getValue())));

        //medicineTable.setItems(value);
        medicineServiceModel
                = new MedicineServiceModel(ComponentManager.GetComponent(IMedicineManagementService.class));

        Medicines medicines = medicineServiceModel.GetMedicines();

        medicineTable.setItems(medicines);

        // Set double click on row edit
        medicineTable.setRowFactory(tv -> {
            TableRow<Medicine> row = new TableRow<>();

            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2
                        && (event.getButton() == MouseButton.PRIMARY)
                        && (!row.isEmpty())) {
                    _manageMedicinesPresenter.UpdateSelectedMedicine();
                }
            });

            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem editMenuItem = new MenuItem("Edit");
            editMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    _manageMedicinesPresenter.UpdateSelectedMedicine();
                }
            });
            final MenuItem removeMenuItem = new MenuItem("Remove");
            removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (confirmDelete()) {
                        _manageMedicinesPresenter.DeleteSelectedMedicine();
                    }
                }
            });
            contextMenu.getItems().add(editMenuItem);
            contextMenu.getItems().add(removeMenuItem);
            // Set context menu on row, but use a binding to make it only show for non-empty rows:  
            row.contextMenuProperty().bind(
                    Bindings.when(row.emptyProperty())
                            .then((ContextMenu) null)
                            .otherwise(contextMenu)
            );
            return row;
        });
    }

    @FXML
    public void AddMedicineButton_OnAction() {
        _manageMedicinesPresenter.AddMedicine();
    }

    @FXML
    public void DeleteMedicineButton_OnAction() {
        if (confirmDelete()) {
            _manageMedicinesPresenter.DeleteSelectedMedicine();
        }
    }

    private boolean confirmDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Delete");
        alert.setHeaderText(
                "Are you sure you want to delete " + this.getSelectedMedicine().getBrandName().getValue() + "?");
        alert.setContentText("Please confirm delete action.");

        ObservableList<ButtonType> buttonTypes = FXCollections.observableArrayList();
        buttonTypes.add(ButtonType.YES);
        buttonTypes.add(ButtonType.CANCEL);
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(buttonTypes);

        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent()) && (result.get() == ButtonType.YES)) {
            return true;
        }

        return false;
    }

    @FXML
    public void UpdateMedicine_OnAction() {
        _manageMedicinesPresenter.UpdateSelectedMedicine();
    }

    @Override
    public Medicines getMedicines() {
        return (Medicines) medicineTable.getItems();
    }

    @Override
    public void setMedicines(Medicines medicines) {
        medicineTable.getItems().clear();
        medicineTable.setItems(medicines);
        
        // Update button states
        if (medicines.isEmpty()) {
            updateButton.setDisable(true);
            deleteButton.setDisable(true);
        } else {
            updateButton.setDisable(false);
            deleteButton.setDisable(false);
        }
    }

    @Override
    public Medicine getSelectedMedicine() {
        return medicineTable.selectionModelProperty().getValue().getSelectedItem();
    }

    @Override
    public String getGenericName() {
        return genericNameTextField.getText();
    }

    @Override
    public String getBrandName() {
        return brandNameTextField.getText();
    }

    @Override
    public void RegisterPresenter(Object presenter) {
        _manageMedicinesPresenter = (ManageMedicinesPresenter) presenter;
    }

    @Override
    public void Show() {
        Stage stage = new Stage();
        stage.setTitle(PropertiesManager.GetUIProperty(UIPropertiesKey.APPLICATION_NAME));

        // Show scene containing the root layout.
        Scene scene = new Scene(_fxmlPane);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void ShowAndWait() {

    }
}
