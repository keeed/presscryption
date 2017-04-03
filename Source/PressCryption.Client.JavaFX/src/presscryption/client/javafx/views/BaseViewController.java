/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.client.javafx.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import presscryption.client.viewdefinitions.IView;

/**
 *
 * @author Kedren Villena
 */
public abstract class BaseViewController implements Initializable, IView {

    protected Pane _fxmlPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public abstract void RegisterPresenter(Object presenter);
    //To change body of generated methods, choose Tools | Templates.

    @Override
    public void SetFXMLLPane(Pane fxmlPane) {
        _fxmlPane = fxmlPane;
    }

    @Override
    public Pane GetFXMLPane() {
        return _fxmlPane;
    }

    @Override
    public abstract void Show();
    //To change body of generated methods, choose Tools | Templates.

    @Override
    public abstract void ShowAndWait();
    
    @Override
    public void ShowMessage(Alert.AlertType alertType, String title, String headerText, String setContentText) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.setContentText(setContentText);

        alert.showAndWait();
    }

}
