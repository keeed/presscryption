/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription;

import java.util.ArrayList;
import presscryption.prescription.contract.objects.PrescriptionDTO;
import presscryption.prescription.contract.objects.PrescriptionMedicineDTO;
import presscryption.prescription.contract.services.IPrescriptionService;
import presscryption.prescription.models.Medicines;
import presscryption.prescription.services.IInternalPrescriptionService;
import presscryption.prescription.services.PrescriptionServiceBuilder;
import presscryption.prescription.translators.MedicineTranslator;
import presscryption.prescription.translators.PrescriptionTranslator;

/**
 *
 * @author Kedren Villena
 */
public class ExternalPrescriptionService implements IPrescriptionService {

    private final IInternalPrescriptionService _prescriptionService;

    public ExternalPrescriptionService() {
        PrescriptionServiceBuilder builder = new PrescriptionServiceBuilder();
        
        _prescriptionService = builder
                .AddTracer()
                .AddExceptionLogger()
                .Build();
    }

    @Override
    public PrescriptionDTO CreatePrescription(ArrayList<PrescriptionMedicineDTO> medicines) {
        Medicines convertedMedicines = new Medicines();
        for (PrescriptionMedicineDTO prescriptionMedicineDTO : medicines) {
            convertedMedicines.AddMedicine(
                    MedicineTranslator.FromDTO(prescriptionMedicineDTO));
        }
        
        return PrescriptionTranslator.ToDTO(
                _prescriptionService.CreatePrescription(convertedMedicines));
    }

}
