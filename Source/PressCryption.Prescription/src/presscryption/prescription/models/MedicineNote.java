/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.models;

import java.util.Objects;

/**
 *
 * @author Kedren Villena
 */
public class MedicineNote  {
    
    private String _note;
    
    public MedicineNote() {
        
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
    
    @Override
    public boolean equals(Object object){
        if (!(object instanceof MedicineNote)) {
            return false;
        }
        
        MedicineNote converted = (MedicineNote)object;
        
        return (converted.getNote() == null ? getNote() == null : converted.getNote().equals(getNote()));
    }
        
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.getNote());
        return hash;
    }
}
