/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.translators;

import presscryption.client.models.Medicine;
import presscryption.medicinemanagement.contract.objects.MedicineDTO;

/**
 *
 * @author Kedren Villena
 */
public class MedicineTranslator {

    public static MedicineDTO ConvertToDTO(Medicine medicine) {
        MedicineDTO medicineDTO = new MedicineDTO();

        medicineDTO.setId(medicine.getId().getValue());
        medicineDTO.setGenericName(medicine.getGenericName().getValue());
        medicineDTO.setBrandName(medicine.getBrandName().getValue());
        medicineDTO.setDateCreated(medicine.getDateCreated().getValue());
        medicineDTO.setDateModified(medicine.getDateModified().getValue());

        return medicineDTO;
    }

    public static Medicine ConvertFromDTO(MedicineDTO medicineDTO) {
        Medicine medicine
                = new Medicine(
                        medicineDTO.getId(),
                        medicineDTO.getGenericName(),
                        medicineDTO.getBrandName(),
                        medicineDTO.getDateCreated(),
                        medicineDTO.getDateModified());

        return medicine;
    }
}
