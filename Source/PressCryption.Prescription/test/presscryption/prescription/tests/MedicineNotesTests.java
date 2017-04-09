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
import presscryption.prescription.models.MedicineNote;
import presscryption.prescription.models.MedicineNotes;

/**
 *
 * @author Kedren Villena
 */
public class MedicineNotesTests {
    
    public MedicineNotesTests() {
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
    public void OnAddMedicineNote_ShouldAddMedicineNote() {
        MedicineNotes medicineNotes = new MedicineNotes();
        MedicineNote newMedicineNote = new MedicineNote();
        newMedicineNote.setNote("New Note");
        
        medicineNotes.AddNote(newMedicineNote);
        
        assertTrue(medicineNotes.ContainsNote(newMedicineNote));
    }
}
