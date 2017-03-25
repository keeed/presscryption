/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.viewdefinitions;

import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;

/**
 *
 * @author Kedren Villena
 */
public interface IView {
    
    public void RegisterPresenter(Object presenter);
    
    public void SetFXMLLPane(Pane fxmlPane);
    
    public Pane GetFXMLPane();
    
    public void Show();
    
    public void ShowMessage(
            AlertType alertType,
            String title,
            String headerText,
            String setContentText);
}
