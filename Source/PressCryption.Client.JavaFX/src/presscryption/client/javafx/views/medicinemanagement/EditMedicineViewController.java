/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.views.medicinemanagement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presscryption.client.constants.UIPropertiesKey;
import presscryption.client.javafx.views.BaseViewController;
import presscryption.client.models.Medicine;
import presscryption.client.presenters.EditMedicinePresenter;
import presscryption.client.viewdefinitions.IEditMedicineView;
import presscryption.common.PropertiesManager;

/**
 * FXML Controller class
 *
 * @author Kedren Villena
 */
public class EditMedicineViewController extends BaseViewController implements Initializable, IEditMedicineView {

    private EditMedicinePresenter _editMedicinePresenter;

    private Medicine _currentMedicine;
    private Stage _currentStage;

    @FXML
    public TextField _genericNameTextField;

    @FXML
    public TextField _brandNameTextField;

    @Override
    public void RegisterPresenter(Object presenter) {
        _editMedicinePresenter = (EditMedicinePresenter) presenter;
    }

    @Override
    public void Show() {

    }

    @Override
    public void ShowAndWait() {
        _currentStage = new Stage();
        _currentStage.setTitle(PropertiesManager.GetUIProperty(UIPropertiesKey.APPLICATION_NAME));

        // Show scene containing the root layout.
        Scene scene = new Scene(_fxmlPane);
        _currentStage.setResizable(false);
        _currentStage.setScene(scene);
        _currentStage.centerOnScreen();
        _currentStage.showAndWait();
    }

    @Override
    public void setMedicine(Medicine medicine) {
        _currentMedicine = new Medicine(medicine);
        bindUIControls(_currentMedicine);
    }

    private void bindUIControls(Medicine medicine) {
        _genericNameTextField.textProperty().bindBidirectional(medicine.getGenericName());
        _brandNameTextField.textProperty().bindBidirectional(medicine.getBrandName());
    }

    @Override
    public Medicine getMedicine() {
        return _currentMedicine;
    }

    @FXML
    public void CancelButton_OnAction() {
        _currentStage.close();
    }

    @FXML
    public void UpdateButton_OnAction() {
        _editMedicinePresenter.UpdateMedicine();
    }

    @Override
    public void UpdateMedicineSuccessful(String message) {
        ShowMessage(Alert.AlertType.INFORMATION, "Success", message, "");
        _currentStage.close();
    }

    @Override
    public void UpdateMedicineFailed(String message) {
        ShowMessage(Alert.AlertType.ERROR, "Failed", message, "");
        _currentStage.close();
    }

    
}
