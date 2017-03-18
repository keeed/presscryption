/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.medicinemanagement.translators;

import presscryption.medicinemanagement.contract.objects.MedicineDTO;
import presscryption.medicinemanagement.data.contract.objects.MedicineDataDTO;

/**
 *
 * @author Kedren Villena
 */
public class MedicineTranslator {
    public static MedicineDTO ConvertToDTO(MedicineDataDTO medicine) {
        MedicineDTO medicineDTO = new MedicineDTO();
        
        medicineDTO.setId(medicine.getId());
        medicineDTO.setGenericName(medicine.getBrandName());
        medicineDTO.setBrandName(medicine.getBrandName());
        medicineDTO.setDateCreated(medicine.getDateCreated());
        medicineDTO.setDateModified(medicine.getDateModified());
        medicineDTO.setQuantity(medicine.getQuantity());

        return medicineDTO;
    }

    public static MedicineDataDTO ConvertToDataDTO(MedicineDTO medicineDTO) {
        MedicineDataDTO medicine
                = new MedicineDataDTO(
                        medicineDTO.getId(),
                        medicineDTO.getGenericName(),
                        medicineDTO.getBrandName(),
                        medicineDTO.getDateCreated(),
                        medicineDTO.getDateModified(),
                        medicineDTO.getQuantity());

        return medicine;
    }
}
