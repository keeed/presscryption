/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.medicinemanagement.data.contract.services;

import java.util.ArrayList;
import presscryption.medicinemanagement.data.contract.objects.MedicineDataDTO;

/**
 *
 * @author Kedren Villena
 */
public interface IMedicineManagementDataService {
    
    long AddMedicine(MedicineDataDTO medicine);
    
    ArrayList<MedicineDataDTO> GetAllMedicine();
    
    void UpdateMedicine(MedicineDataDTO medicine);
    
    void DeleteMedicine(MedicineDataDTO medicine);
    
}
