/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.medicinemanagement.contract.services;

import java.util.ArrayList;
import presscryption.medicinemanagement.contract.objects.MedicineDTO;

/**
 *
 * @author Kedren Villena
 */
public interface IMedicineManagementService {
    
    ArrayList<MedicineDTO> GetAllMedicine();
    
    MedicineDTO GetMedicine(MedicineDTO medicineToSearch);
    
    boolean CheckIfMedicineExisting(MedicineDTO medicineToSearch);
    
    long AddMedicine(MedicineDTO medicine);
    
    void EditMedicine(MedicineDTO medicine);
    
    void DeleteMedicine(MedicineDTO medicine);
    
}
