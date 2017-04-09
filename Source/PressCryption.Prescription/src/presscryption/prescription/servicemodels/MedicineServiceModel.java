/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.servicemodels;

import presscryption.medicinemanagement.contract.objects.MedicineDTO;
import presscryption.medicinemanagement.contract.services.IMedicineManagementService;
import presscryption.prescription.models.Medicine;
import presscryption.prescription.models.Medicines;

/**
 *
 * @author Kedren Villena
 */
public class MedicineServiceModel {
    
    private IMedicineManagementService _medicineManagementService;
    
    public MedicineServiceModel(IMedicineManagementService medicineManagementService) { 
        if (medicineManagementService == null) {
            throw new IllegalArgumentException("medicineManagementService");
        }     
        _medicineManagementService = medicineManagementService;
    }
    
    /**
     * Sync received Medicines with medicines from the IMedicineManagementService
     * @param medicines
     * @return 
     */
    public Medicines SyncMedicines(Medicines medicines) {
        for(Medicine medicine : medicines) {
            MedicineDTO medicineDTO = 
                    _medicineManagementService.GetMedicine(
                        MedicineManagementServiceTranslator.ToDTO(medicine));
            
            medicine.setGenericName(medicineDTO.getGenericName());
            medicine.setBrandName(medicineDTO.getBrandName());
        }        
        
        return medicines;
    }
}
