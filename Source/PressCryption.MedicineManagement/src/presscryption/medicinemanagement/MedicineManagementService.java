/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.medicinemanagement;

import java.util.ArrayList;
import presscryption.common.ComponentManager;
import presscryption.medicinemanagement.contract.objects.MedicineDTO;
import presscryption.medicinemanagement.contract.services.IMedicineManagementService;
import presscryption.medicinemanagement.data.contract.objects.MedicineDataDTO;
import presscryption.medicinemanagement.data.contract.services.IMedicineManagementDataService;
import presscryption.medicinemanagement.translators.MedicineTranslator;

/**
 *
 * @author Kedren Villena
 */
public class MedicineManagementService implements IMedicineManagementService {
    private static IMedicineManagementDataService _medicineManagementDataService = null;

    private static IMedicineManagementDataService getMedicineManagementDataService() {
        if (_medicineManagementDataService == null) {
            _medicineManagementDataService
                    = ComponentManager.GetComponent(IMedicineManagementDataService.class);
        }

        return _medicineManagementDataService;
    }

    @Override
    public ArrayList<MedicineDTO> GetAllMedicine() {
        IMedicineManagementDataService medicineManagementDataService
                = getMedicineManagementDataService();

        ArrayList<MedicineDataDTO> medicinesDataDTO
                = medicineManagementDataService.GetAllMedicine();

        ArrayList<MedicineDTO> medicinesDTO = new ArrayList<>();
        
        for(MedicineDataDTO medicineDataDTO : medicinesDataDTO) {
            medicinesDTO.add(MedicineTranslator.ConvertToDTO(medicineDataDTO));
        }
        
        return medicinesDTO;
    }

    @Override
    public MedicineDTO GetMedicine(MedicineDTO medicineToSearch) {
        IMedicineManagementDataService medicineManagementDataService
                = getMedicineManagementDataService();

        MedicineDataDTO medicineDataDTO
                 = medicineManagementDataService.GetMedicine(
                         MedicineTranslator.ConvertToDataDTO(medicineToSearch));
        
        return MedicineTranslator.ConvertToDTO(medicineDataDTO);
    }

    @Override
    public boolean CheckIfMedicineExisting(MedicineDTO medicineToSearch) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long AddMedicine(MedicineDTO medicine) {
        IMedicineManagementDataService medicineManagementDataService
                = getMedicineManagementDataService();

        long id
                = medicineManagementDataService.AddMedicine(
                        MedicineTranslator.ConvertToDataDTO(medicine));

        return id;
    }

    @Override
    public void EditMedicine(MedicineDTO medicine) {
        IMedicineManagementDataService medicineManagementDataService
                = getMedicineManagementDataService();
        
        medicineManagementDataService.UpdateMedicine(
                MedicineTranslator.ConvertToDataDTO(medicine));
    }

    @Override
    public void DeleteMedicine(MedicineDTO medicine) {
        IMedicineManagementDataService medicineManagementDataService
                = getMedicineManagementDataService();
        
        medicineManagementDataService.DeleteMedicine(
                MedicineTranslator.ConvertToDataDTO(medicine));
    }
}
