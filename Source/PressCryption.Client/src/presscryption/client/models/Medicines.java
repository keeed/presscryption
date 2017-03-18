/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.models;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;

/**
 *
 * @author Kedren Villena
 */
public class Medicines extends SimpleListProperty<Medicine> {
    
    public Medicines() {
        super(FXCollections.observableArrayList());
    }
    
    public void AddMedicine(Medicine medicine) {
        super.add(medicine);
    }
    
}
