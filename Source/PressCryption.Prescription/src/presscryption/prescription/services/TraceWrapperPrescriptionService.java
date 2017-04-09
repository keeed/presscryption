/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.services;

import presscryption.prescription.models.Medicines;
import presscryption.prescription.models.Prescription;

/**
 * Decorator Class for adding Trace Logger to Prescription Service
 *
 * @author Kedren Villena
 */
public class TraceWrapperPrescriptionService implements IInternalPrescriptionService {

    private IInternalPrescriptionService _prescriptionService;

    public TraceWrapperPrescriptionService(
            IInternalPrescriptionService prescriptionService) {

        if (prescriptionService == null) {
            throw new IllegalArgumentException("prescriptionService");
        }

        _prescriptionService = prescriptionService;
    }

    /**
     *
     * @param medicines
     * @return
     */
    @Override
    public Prescription CreatePrescription(Medicines medicines) {
        // Logger Code....
        Prescription prescription = _prescriptionService.CreatePrescription(medicines);
        // More Logging
        return prescription;
    }
}
