/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.presenters;

import presscryption.client.models.Medicine;
import presscryption.client.viewdefinitions.IEditMedicineView;
import presscryption.servicemodels.IMedicineServiceModel;

/**
 *
 * @author Kedren Villena
 */
public class EditMedicinePresenter {

    private IEditMedicineView _editMedicineView;
    private IMedicineServiceModel _medicineServiceModel;

    public EditMedicinePresenter(
            IEditMedicineView editMedicineView,
            IMedicineServiceModel medicineServiceModel) {

        if (editMedicineView == null) {
            throw new IllegalArgumentException("editMedicineView");
        }

        setEditMedicineView(editMedicineView);

        if (medicineServiceModel == null) {
            throw new IllegalArgumentException("medicineServiceModel");
        }

        setMedicineServiceModel(medicineServiceModel);
    }

    /**
     * @return the _editMedicineView
     */
    public IEditMedicineView getEditMedicineView() {
        return _editMedicineView;
    }

    /**
     * @param _editMedicineView the _editMedicineView to set
     */
    protected void setEditMedicineView(IEditMedicineView _editMedicineView) {
        this._editMedicineView = _editMedicineView;
    }

    /**
     * @return the _medicineServiceModel
     */
    public IMedicineServiceModel getMedicineServiceModel() {
        return _medicineServiceModel;
    }

    /**
     * @param _medicineServiceModel the _medicineServiceModel to set
     */
    protected void setMedicineServiceModel(IMedicineServiceModel _medicineServiceModel) {
        this._medicineServiceModel = _medicineServiceModel;
    }

    public void SetSelectedMedicine(Medicine medicine) {
        _editMedicineView.setMedicine(medicine);
    }

    public void UpdateMedicine() {
        Medicine medicine = _editMedicineView.getMedicine();
        boolean isSuccessful = true;

        try {
            _medicineServiceModel.UpdateMedicine(medicine);
        } catch (Exception ex) {
            isSuccessful = false;
            _editMedicineView.UpdateMedicineFailed(ex.getMessage());
        }
        
        if (isSuccessful) {
            _editMedicineView.UpdateMedicineSuccessful("Medicine successfully updated.");
        }
    }

}
