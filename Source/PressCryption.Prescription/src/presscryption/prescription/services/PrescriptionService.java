/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.services;

import presscryption.prescription.models.Medicines;
import presscryption.prescription.models.Prescription;
import presscryption.prescription.servicemodels.MedicineServiceModel;

/**
 * 
 * @author Kedren Villena
 */
public class PrescriptionService implements IInternalPrescriptionService {
    
    private MedicineServiceModel _medicineServiceModel;
    
    public PrescriptionService(MedicineServiceModel medicineServiceModel) {
        
        if (medicineServiceModel == null) {
            throw new IllegalArgumentException("medicineServiceModel");
        }
        
        _medicineServiceModel = medicineServiceModel;
    }
    
    @Override
    public Prescription CreatePrescription(Medicines medicines) {
        Prescription prescription = new Prescription();
        
        medicines = _medicineServiceModel.SyncMedicines(medicines);
        
        prescription.AddMedicines(medicines);
        
        return prescription;
    }
    
}
