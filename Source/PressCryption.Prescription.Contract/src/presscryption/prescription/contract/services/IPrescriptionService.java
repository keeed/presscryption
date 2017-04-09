/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.contract.services;

import java.util.ArrayList;
import presscryption.prescription.contract.objects.PrescriptionDTO;
import presscryption.prescription.contract.objects.PrescriptionMedicineDTO;

/**
 *
 * @author Kedren Villena
 */
public interface IPrescriptionService {
    
    /**
     *
     * @param medicines
     * @return
     */
    public PrescriptionDTO CreatePrescription(ArrayList<PrescriptionMedicineDTO> medicines);
    
}
