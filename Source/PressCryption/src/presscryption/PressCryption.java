/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import presscryption.client.constants.UIPropertiesKey;
import presscryption.client.presenterfactories.HomePresenterFactory;
import presscryption.client.presenters.HomePresenter;
import presscryption.common.PropertiesManager;
import presscryption.views.RootLayoutController;

/**
 *
 * @author Kedren Villena
 */
public class PressCryption extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void init() {
        initializeProperties("PressCryption.properties");
        intializeUIPropeties("PressCryption.UI.properties");
        PropertiesManager.CreateComponents();
    }

    private static void initializeProperties(String path) {
        PropertiesManager.LoadProperties(PressCryption.class.getResourceAsStream(path));
    }
    
    private void intializeUIPropeties(String path) {
        PropertiesManager.LoadUIProperties(PressCryption.class.getResourceAsStream(path));
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage
                .setTitle(PropertiesManager.GetUIProperty(UIPropertiesKey.APPLICATION_NAME));

        initializeRootLayout();

        showHomeView();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void initializeRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PressCryption.class.getResource("views/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            //controller.setMainApp(this);

            primaryStage.show();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void showHomeView() {
        HomePresenter homeViewPresenter = HomePresenterFactory.CreateInstance();
        
        rootLayout.setCenter(homeViewPresenter.getHomeView().GetFXMLPane());
    }
}
