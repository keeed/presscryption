/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.services;

import presscryption.common.ComponentManager;
import presscryption.medicinemanagement.contract.services.IMedicineManagementService;
import presscryption.prescription.servicemodels.MedicineServiceModel;

/**
 *
 * @author Kedren Villena
 */
public class PrescriptionServiceBuilder {

    private IInternalPrescriptionService _prescriptionService;
    private final MedicineServiceModel _medicineServiceModel;

    public PrescriptionServiceBuilder() {      
        _medicineServiceModel
                = new MedicineServiceModel(
                        ComponentManager.GetComponent(IMedicineManagementService.class));
        
        _prescriptionService = new PrescriptionService(_medicineServiceModel);
    }

    public PrescriptionServiceBuilder AddTracer() {
        _prescriptionService = new TraceWrapperPrescriptionService(_prescriptionService);
        return this;
    }
    
    public PrescriptionServiceBuilder AddExceptionLogger() {
        _prescriptionService = new ExceptionWrapperPrescriptionService(_prescriptionService);
        return this;
    }
    
    public IInternalPrescriptionService Build() {
        return _prescriptionService;
    }
}
