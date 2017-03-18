/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import presscryption.client.viewdefinitions.IHomeView;

/**
 * FXML Controller class
 *
 * @author Kedren Villena
 */
public class HomeViewController implements Initializable, IHomeView {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void Show() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ShowMessage(String message, boolean isError) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @FXML
    public void handleMedicineManagementButton_OnAction() {
        
    }
    
    @FXML
    public void handlePrescriptionButton_OnAction() {
        
    }
}
