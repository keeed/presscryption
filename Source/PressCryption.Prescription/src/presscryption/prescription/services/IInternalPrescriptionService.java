/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.services;

import presscryption.prescription.models.Medicines;
import presscryption.prescription.models.Prescription;

/**
 *
 * @author Kedren Villena
 */
public interface IInternalPrescriptionService {
    
    public Prescription CreatePrescription(Medicines medicines);
    
}
