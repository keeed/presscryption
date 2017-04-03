/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.servicemodels;

import presscryption.client.models.Medicine;
import presscryption.client.models.Medicines;

/**
 *
 * @author Kedren Villena
 */
public interface IMedicineServiceModel {
    
    public Medicines GetMedicines();

    public long AddMedicine(Medicine medicine);

    public void DeleteMedicine(Medicine medicine);
    
    public void UpdateMedicine(Medicine medicine);
}
