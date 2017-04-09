/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.services;

import presscryption.prescription.models.Medicines;
import presscryption.prescription.models.Prescription;

/**
 * Decorator class for wrapping the PrescriptionService with exception handling.
 *
 * @author Kedren Villena
 */
public class ExceptionWrapperPrescriptionService implements IInternalPrescriptionService {

    private IInternalPrescriptionService _prescriptionService;

    /**
     *
     * @param prescriptionService
     */
    public ExceptionWrapperPrescriptionService(IInternalPrescriptionService prescriptionService) {
        
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
        Prescription prescription = null;
        try {
            prescription = _prescriptionService.CreatePrescription(medicines);
        } catch (Exception ex) {

        }
        return prescription;
    }
}
