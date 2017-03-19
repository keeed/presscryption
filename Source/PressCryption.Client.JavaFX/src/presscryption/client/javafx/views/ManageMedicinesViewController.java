/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.views;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import presscryption.client.models.Medicine;
import presscryption.client.models.Medicines;
import presscryption.common.ComponentManager;
import presscryption.medicinemanagement.contract.services.IMedicineManagementService;
import presscryption.servicemodels.IMedicineServiceModel;
import presscryption.servicemodels.MedicineServiceModel;

/**
 * FXML Controller class
 *
 * @author Kedren Villena
 */
public class ManageMedicinesViewController implements Initializable {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    
    @FXML
    private TextField genericNameTextField;
    @FXML
    private TextField brandNameTextField;

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
    }

    @FXML
    public void AddMedicineButton_OnAction() {
        String genericName = genericNameTextField.getText();
        String brandName = brandNameTextField.getText();

        if (genericName.isEmpty() && brandName.isEmpty()) {
            return;
        }
        Medicine newMedicine
                = new Medicine(0, genericName, brandName, LocalDateTime.now(), LocalDateTime.now());

        medicineServiceModel.AddMedicine(newMedicine);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.initOwner(null);
        alert.setTitle("Success");
        alert.setHeaderText("New Medicine Successfully Added!");
        alert.setContentText("Sucess");

        alert.showAndWait();
    }
}
