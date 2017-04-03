/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.viewdefinitions;

import presscryption.client.models.Medicine;

/**
 *
 * @author Kedren Villena
 */
public interface IEditMedicineView extends IView {

    public void setMedicine(Medicine medicine);

    public Medicine getMedicine();
    
    public void UpdateMedicineSuccessful(String message);
    
    public void UpdateMedicineFailed(String message);
}
