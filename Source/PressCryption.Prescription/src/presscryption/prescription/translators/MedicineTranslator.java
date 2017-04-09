/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.translators;

import java.util.ArrayList;
import presscryption.prescription.contract.objects.PrescriptionMedicineDTO;
import presscryption.prescription.contract.objects.PrescriptionMedicineNoteDTO;
import presscryption.prescription.models.Medicine;
import presscryption.prescription.models.MedicineNote;
import presscryption.prescription.models.MedicineNotes;

/**
 *
 * @author Kedren Villena
 */
public final class MedicineTranslator {
    
    public static PrescriptionMedicineDTO ToDTO(Medicine medicine) {
        PrescriptionMedicineDTO prescriptionMedicineDTO
                = new PrescriptionMedicineDTO();
        
        prescriptionMedicineDTO.setId(medicine.getId());
        prescriptionMedicineDTO.setGenericName(medicine.getGenericName());
        prescriptionMedicineDTO.setBrandName(medicine.getBrandName());
        
        ArrayList<PrescriptionMedicineNoteDTO> medicineNotes = new ArrayList<>();
        for (MedicineNote medicineNote : medicine.getMedicineNotes()) {
            PrescriptionMedicineNoteDTO prescriptionMedicineNote 
                    = new PrescriptionMedicineNoteDTO();
            prescriptionMedicineNote.setNote(medicineNote.getNote());
            medicineNotes.add(prescriptionMedicineNote);
        }
        
        prescriptionMedicineDTO.setNotes(medicineNotes);
        
        return prescriptionMedicineDTO;
    }
    
    public static Medicine FromDTO(PrescriptionMedicineDTO prescriptionMedicineDTO) {
        Medicine medicine
                = new Medicine();
        
        medicine.setId(prescriptionMedicineDTO.getId());
        medicine.setGenericName(prescriptionMedicineDTO.getGenericName());
        medicine.setBrandName(prescriptionMedicineDTO.getBrandName());
        
        MedicineNotes medicineNotes = new MedicineNotes();
        
        for (PrescriptionMedicineNoteDTO medicineNoteDTO : prescriptionMedicineDTO.getNotes()) {
            MedicineNote medicineNote = new MedicineNote();
            medicineNote.setNote(medicineNoteDTO.getNote());
            medicineNotes.AddNote(medicineNote);
        }
        
        medicine.setMedicineNotes(medicineNotes);
        
        return medicine;
    }
    
}
