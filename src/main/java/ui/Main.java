package ui;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.UIConstants;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    private static Logger logger = LogManager.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.info("Building FXMLLoader, loading resources");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/login.fxml"));
        loader.setResources(ResourceBundle.getBundle("bundles.locale", new Locale("en")));

        logger.info("Loading the loader");
        Parent fxmlMain = loader.load();
        LoginController loginController = loader.getController();
        loginController.setMainStage(primaryStage);

        logger.info("Loading the \"Login\" scene\n");
        Scene scene = new Scene(fxmlMain, UIConstants.loginWindowWidth, UIConstants.loginWindowHeight);
        primaryStage.setTitle(loader.getResources().getString("title.name.login"));
        primaryStage.setMinWidth(280);
        primaryStage.setMinHeight(150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
