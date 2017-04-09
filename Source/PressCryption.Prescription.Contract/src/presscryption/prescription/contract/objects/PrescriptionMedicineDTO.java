/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.contract.objects;

import java.util.ArrayList;

/**
 *
 * @author Kedren Villena
 */
public class PrescriptionMedicineDTO {
    
    private long _id;
    private String _genericName;
    private String _brandName;
    private ArrayList<PrescriptionMedicineNoteDTO> _notes;
    
    public PrescriptionMedicineDTO() {
        
    }

    /**
     * @return the _id
     */
    public long getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(long _id) {
        this._id = _id;
    }

    /**
     * @return the _genericName
     */
    public String getGenericName() {
        return _genericName;
    }

    /**
     * @param _genericName the _genericName to set
     */
    public void setGenericName(String _genericName) {
        this._genericName = _genericName;
    }

    /**
     * @return the _brandName
     */
    public String getBrandName() {
        return _brandName;
    }

    /**
     * @param _brandName the _brandName to set
     */
    public void setBrandName(String _brandName) {
        this._brandName = _brandName;
    }

    /**
     * @return the _notes
     */
    public ArrayList<PrescriptionMedicineNoteDTO> getNotes() {
        return _notes;
    }

    /**
     * @param _notes the _notes to set
     */
    public void setNotes(ArrayList<PrescriptionMedicineNoteDTO> _notes) {
        this._notes = _notes;
    }
    
}
