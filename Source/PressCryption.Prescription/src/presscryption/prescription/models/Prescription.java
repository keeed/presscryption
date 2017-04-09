/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.models;

/**
 *
 * @author Kedren Villena
 */
public class Prescription {
    
    private Medicines _medicines;
    
    public Prescription() {
        
    }
    
    /**
     * Adds all the Medicines.
     * Will call AddMedicine internally to ensure uniqueness.
     * @param medicines 
     */
    public void AddMedicines(Medicines medicines) {
        for (Medicine medicine : medicines) {
            AddMedicine(medicine);
        }
    }
    
    /**
     * Adds a new Medicine to the prescription.
     * Duplicate Medicine will not be added.
     * @param medicine 
     */
    public void AddMedicine(Medicine medicine) {
        if (!_medicines.ContainsMedicine(medicine)) {
            _medicines.AddMedicine(medicine);
        }
    }
    
    /**
     * 
     * @return 
     */
    public Medicines GetMedicines() {
        return _medicines;
    }
}
