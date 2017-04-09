/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.contract.objects;

/**
 *
 * @author Kedren Villena
 */
public class PrescriptionMedicineNoteDTO {
    
    private String _note;
    
    public PrescriptionMedicineNoteDTO() {
        
    }

    /**
     * @return the _note
     */
    public String getNote() {
        return _note;
    }

    /**
     * @param _note the _note to set
     */
    public void setNote(String _note) {
        this._note = _note;
    }
    
}
