/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.viewfactories;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presscryption.client.javafx.views.medicinemanagement.ManageMedicinesViewController;
import presscryption.client.viewdefinitions.IManageMedicinesView;
import presscryption.client.viewfactories.IManageMedicinesViewFactory;

/**
 *
 * @author Kedren Villena
 */
public class ManageMedicinesViewFactory implements IManageMedicinesViewFactory {

    @Override
    public IManageMedicinesView CreateManageMedicinesView() {
        
        IManageMedicinesView manageMedicinesView = null;
        
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(ManageMedicinesViewController.class.getResource("ManageMedicinesView.fxml"));
            AnchorPane layout = (AnchorPane) loader.load();

            manageMedicinesView = loader.getController();
            manageMedicinesView.SetFXMLLPane(layout);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return manageMedicinesView;
    }
      
}
