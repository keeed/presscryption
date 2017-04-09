/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.translators;

import java.util.ArrayList;
import presscryption.prescription.contract.objects.PrescriptionDTO;
import presscryption.prescription.contract.objects.PrescriptionMedicineDTO;
import presscryption.prescription.models.Medicine;
import presscryption.prescription.models.Prescription;

/**
 *
 * @author Kedren Villena
 */
public final class PrescriptionTranslator {
    
    public static PrescriptionDTO ToDTO(Prescription prescription) {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        
        ArrayList<PrescriptionMedicineDTO> medicinesDTO 
                = new ArrayList<>();
        
        for (Medicine medicine : prescription.GetMedicines()) {
            medicinesDTO.add(
                MedicineTranslator.ToDTO(medicine));
        }
        
        prescriptionDTO.setPrescriptionMedicines(medicinesDTO);
        
        return prescriptionDTO;
    }
    
}
