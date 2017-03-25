/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import presscryption.client.presenters.HomePresenter;
import presscryption.client.viewdefinitions.IHomeView;

/**
 * FXML Controller class
 *
 * @author Kedren Villena
 */
public class HomeViewController implements Initializable, IHomeView {
    
    private HomePresenter _homePresenter;
    private Pane _fxmlPane;
    
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
    public void RegisterPresenter(Object presenter) {
        _homePresenter = (HomePresenter) presenter;
    }

    @Override
    public Pane GetFXMLPane() {
        return _fxmlPane;
    }

    @Override
    public void Show() {
        
    }

    @Override
    public void ShowMessage(Alert.AlertType alertType, String title, String headerText, String setContentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(setContentText);
        
        alert.showAndWait();
    }
    
    @FXML
    public void handleMedicineManagementButton_OnAction() {
        _homePresenter.ShowManageMedicinesView();
    }
    
    @FXML
    public void handlePrescriptionButton_OnAction() {
        
    }

    @Override
    public void SetFXMLLPane(Pane fxmlPane) {
        _fxmlPane = fxmlPane;
    }

}
