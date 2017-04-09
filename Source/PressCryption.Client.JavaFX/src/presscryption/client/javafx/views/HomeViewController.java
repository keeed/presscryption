/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.views;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import presscryption.client.javafx.views.BaseViewController;
import presscryption.client.presenters.HomePresenter;
import presscryption.client.viewdefinitions.IHomeView;

/**
 * FXML Controller class
 *
 * @author Kedren Villena
 */
public class HomeViewController extends BaseViewController implements Initializable, IHomeView {

    private HomePresenter _homePresenter;

    @Override
    public void RegisterPresenter(Object presenter) {
        _homePresenter = (HomePresenter) presenter;
    }

    @Override
    public void Show() {

    }

    @Override
    public void ShowAndWait() {
        
    }
    
    @FXML
    public void handleMedicineManagementButton_OnAction() {
        _homePresenter.ShowManageMedicinesView();
    }

    @FXML
    public void handlePrescriptionButton_OnAction() {

    }

}
