/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.presenters;

import javafx.scene.control.Alert;
import presscryption.client.models.Medicine;
import presscryption.client.models.Medicines;
import presscryption.client.viewdefinitions.IManageMedicinesView;
import presscryption.servicemodels.IMedicineServiceModel;

/**
 *
 * @author Kedren Villena
 */
public class ManageMedicinesPresenter {
    private IManageMedicinesView _manageMedicinesView;
    private IMedicineServiceModel _medicineServiceModel;

    public ManageMedicinesPresenter(
            IManageMedicinesView manageMedicinesView,
            IMedicineServiceModel medicineServiceModel) {

        if (manageMedicinesView == null) {
            throw new IllegalArgumentException("manageMedicinesView");
        }

        setManageMedicinesView(manageMedicinesView);

        if (medicineServiceModel == null) {
            throw new IllegalArgumentException("medicineServiceModel");
        }

        setMedicineServiceModel(medicineServiceModel);
    }

    /**
     * @return the _ManageMedicinesView
     */
    public IManageMedicinesView getManageMedicinesView() {
        return _manageMedicinesView;
    }

    /**
     * @param ManageMedicinesView the _ManageMedicinesView to set
     */
    private void setManageMedicinesView(IManageMedicinesView ManageMedicinesView) {
        this._manageMedicinesView = ManageMedicinesView;
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
    private void setMedicineServiceModel(IMedicineServiceModel _medicineServiceModel) {
        this._medicineServiceModel = _medicineServiceModel;
    }

    public void OnInitialize() {
        loadMedicines();
    }

    private void loadMedicines() {
        Medicines medicines = _medicineServiceModel.GetMedicines();
        _manageMedicinesView.setMedicines(medicines);
    }

    public void AddMedicine() {
        Medicine newMedicine 
                = new Medicine(
                        _manageMedicinesView.getGenericName(), 
                        _manageMedicinesView.getBrandName());
        
        long newMedicineId = _medicineServiceModel.AddMedicine(newMedicine);
        
        if (newMedicineId == -1) {
            _manageMedicinesView.ShowMessage(
                    Alert.AlertType.ERROR, 
                    "Error", 
                    "Failed to add Medicine!", 
                    "Please contact Administrator.");
        }
        else {
            _manageMedicinesView.ShowMessage(
                    Alert.AlertType.INFORMATION,
                    "Success",
                    newMedicine.getGenericName().getValue() + " - " + newMedicine.getBrandName().getValue() + " was succesfully added.",
                    "Result Code: Success");
        }
        
        loadMedicines();
    }
}
