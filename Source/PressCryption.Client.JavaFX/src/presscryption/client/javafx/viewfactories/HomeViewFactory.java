/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.viewfactories;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presscryption.client.javafx.views.HomeViewController;
import presscryption.client.viewdefinitions.IHomeView;
import presscryption.client.viewfactories.IHomeViewFactory;

/**
 *
 * @author Kedren Villena
 */
public class HomeViewFactory implements IHomeViewFactory {

    @Override
    public IHomeView CreateHomeView() {
        
        IHomeView homeView = null;
        
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(HomeViewController.class.getResource("HomeView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            HomeViewController controller = loader.getController();
            
            controller.SetFXMLLPane(personOverview);
            
            homeView = controller;

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return homeView;
    }
    
}
