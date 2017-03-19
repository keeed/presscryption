/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.viewdefinitions;

import presscryption.client.models.Medicine;
import presscryption.client.models.Medicines;

/**
 *
 * @author Kedren Villena
 */
public interface IManageMedicinesView extends IView {

    public Medicines getMedicines();
    public void setMedicines(Medicines medicines);
    
    public Medicine getSelectedMedicine();
    
    public String getGenericName();
    public String getBrandName();
    public int getQuantity();
}
