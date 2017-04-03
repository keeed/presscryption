/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.viewfactories;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presscryption.client.javafx.views.EditMedicineViewController;
import presscryption.client.viewdefinitions.IEditMedicineView;
import presscryption.client.viewfactories.IEditMedicineViewFactory;

/**
 *
 * @author Kedren Villena
 */
public class EditMedicineViewFactory implements IEditMedicineViewFactory {

    @Override
    public IEditMedicineView CreateEditeMedicineView() {
        IEditMedicineView editMedicineView = null;
        
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EditMedicineViewController.class.getResource("EditMedicineView.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            EditMedicineViewController controller = loader.getController();
            
            controller.SetFXMLLPane(personOverview);
            
            editMedicineView = controller;

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return editMedicineView;
    }
    
}
