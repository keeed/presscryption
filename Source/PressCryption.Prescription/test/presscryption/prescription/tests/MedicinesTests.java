/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.prescription.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import presscryption.prescription.models.Medicine;
import presscryption.prescription.models.MedicineNotes;
import presscryption.prescription.models.Medicines;

/**
 *
 * @author Kedren Villena
 */
public class MedicinesTests {
    
    public MedicinesTests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void OnAddMedicine_ShouldAddMedicine() {
        Medicines medicines = new Medicines();
        Medicine newMedicine = new Medicine();
        newMedicine.setId(0);
        newMedicine.setGenericName("Paracetamol");
        newMedicine.setBrandName("Biogesic");
        newMedicine.setMedicineNotes(new MedicineNotes());
        
        medicines.AddMedicine(newMedicine);
        
        assertTrue(medicines.ContainsMedicine(newMedicine));
    }
}
