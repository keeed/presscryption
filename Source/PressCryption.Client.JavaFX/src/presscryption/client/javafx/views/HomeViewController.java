/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
        
    }

    @Override
    public void ShowMessage(String message, boolean isError) {
        
    }
    
    @FXML
    public void handleMedicineManagementButton_OnAction() {
        showMedicineManagementView();
    }
    
    @FXML
    public void handlePrescriptionButton_OnAction() {
        
    }
    
    public void showMedicineManagementView() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ManageMedicinesViewController.class.getResource("ManageMedicinesView.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("PressCryption");
            
            // Show scene containing the root layout.
            Scene scene = new Scene(layout);
            stage.setScene(scene);

            stage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
