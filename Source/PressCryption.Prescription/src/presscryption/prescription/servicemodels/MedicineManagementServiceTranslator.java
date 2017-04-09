/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.servicemodels;

import presscryption.medicinemanagement.contract.objects.MedicineDTO;
import presscryption.prescription.models.Medicine;

/**
 *
 * @author Kedren Villena
 */
public final class MedicineManagementServiceTranslator {
    
    public static MedicineDTO ToDTO(Medicine medicine) {
        MedicineDTO medicineDTO;
        medicineDTO = new MedicineDTO();
        
        medicineDTO.setId(medicine.getId());
        medicineDTO.setGenericName(medicine.getGenericName());
        medicineDTO.setBrandName(medicine.getBrandName());
        
        return medicineDTO;
    }
    
    public static Medicine FromDTO(MedicineDTO medicineDTO) {
        Medicine medicine;
        medicine = new Medicine();
        
        medicine.setId(medicineDTO.getId());
        medicine.setGenericName(medicineDTO.getGenericName());
        medicine.setBrandName(medicineDTO.getBrandName());
        
        return medicine;
    }
}
