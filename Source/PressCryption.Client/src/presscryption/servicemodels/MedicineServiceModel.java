/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.servicemodels;

import java.util.ArrayList;
import presscryption.client.models.Medicine;
import presscryption.client.models.Medicines;
import presscryption.medicinemanagement.contract.objects.MedicineDTO;
import presscryption.medicinemanagement.contract.services.IMedicineManagementService;
import presscryption.translators.MedicineTranslator;

/**
 *
 * @author Kedren Villena
 */
public class MedicineServiceModel implements IMedicineServiceModel {

    private IMedicineManagementService _medicineManagementService;

    public MedicineServiceModel(
            IMedicineManagementService medicineManagementService) {

        if (medicineManagementService == null) {
            throw new IllegalArgumentException("medicineManagementService");
        }

        setMedicineManagementService(medicineManagementService);
    }

    /**
     * @return the _medicineManagementService
     */
    protected IMedicineManagementService getMedicineManagementService() {
        return _medicineManagementService;
    }

    /**
     * @param MedicineManagementService the _medicineManagementService to set
     */
    private void setMedicineManagementService(IMedicineManagementService MedicineManagementService) {
        this._medicineManagementService = MedicineManagementService;
    }

    @Override
    public Medicines GetMedicines() {
        ArrayList<MedicineDTO> medicinesDTO
                = _medicineManagementService.GetAllMedicine();

        Medicines medicines = new Medicines();

        for (MedicineDTO medicineDTO : medicinesDTO) {
            medicines.AddMedicine(MedicineTranslator.ConvertFromDTO(medicineDTO));
        }

        return medicines;
    }

    @Override
    public long AddMedicine(Medicine medicine) {
        MedicineDTO medicineDTO = MedicineTranslator.ConvertToDTO(medicine);
        long id = _medicineManagementService.AddMedicine(medicineDTO);

        return id;
    }

    @Override
    public void DeleteMedicine(Medicine medicine) {
        MedicineDTO medicineDTO = MedicineTranslator.ConvertToDTO(medicine);
        _medicineManagementService.DeleteMedicine(medicineDTO);
    }
    
    @Override
    public void UpdateMedicine(Medicine medicine) {
        MedicineDTO medicineDTO = MedicineTranslator.ConvertToDTO(medicine);
        _medicineManagementService.EditMedicine(medicineDTO);
    }
}
