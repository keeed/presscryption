/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.models;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Kedren Villena
 */
public class MedicineNotes implements Iterable<MedicineNote> {
    private final ArrayList<MedicineNote> _medicineNotes 
            = new ArrayList<>();

    public MedicineNotes() {
        
    }
    
    public void AddNote(MedicineNote note) {
        _medicineNotes.add(note);
    }
    
    public boolean ContainsNote(MedicineNote note) {
        for (MedicineNote medicineNote : _medicineNotes) {
            if (medicineNote.equals(note)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Iterator<MedicineNote> iterator() {
        return _medicineNotes.iterator();
    }
}
