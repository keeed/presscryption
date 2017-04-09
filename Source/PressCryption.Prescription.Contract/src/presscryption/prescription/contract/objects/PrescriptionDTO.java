/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.contract.objects;

import java.util.ArrayList;

/**
 *
 * @author Kedren Villena
 */
public class PrescriptionDTO {
    
    private ArrayList<PrescriptionMedicineDTO> _prescriptionMedicines;
    
    public PrescriptionDTO() {
        
    }

    /**
     * @return the _prescriptionMedicines
     */
    public ArrayList<PrescriptionMedicineDTO> getPrescriptionMedicines() {
        return _prescriptionMedicines;
    }

    /**
     * @param _prescriptionMedicines the _prescriptionMedicines to set
     */
    public void setPrescriptionMedicines(ArrayList<PrescriptionMedicineDTO> _prescriptionMedicines) {
        this._prescriptionMedicines = _prescriptionMedicines;
    }
}
