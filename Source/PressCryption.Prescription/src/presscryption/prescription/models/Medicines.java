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
public class Medicines implements Iterable<Medicine> {
    
    private final ArrayList<Medicine> _prescriptionMedicines
            = new ArrayList<>();
    
    public Medicines() {
        
    }
    
    public void AddMedicine(Medicine medicine) {
        _prescriptionMedicines.add(medicine);
    }
    
    public boolean ContainsMedicine(Medicine medicine) {
        return _prescriptionMedicines.contains(medicine);
    }

    @Override
    public Iterator iterator() {
        return _prescriptionMedicines.iterator();
    }
}
