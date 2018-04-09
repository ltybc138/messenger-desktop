package ui;

import controller.LoginController;
import controller.RegisterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.UIConstants;
import utils.logging.ConsoleLogger;

import java.util.Locale;
import java.util.ResourceBundle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/login.fxml"));
//        loader.setLocation(getClass().getResource("../fxml/register.fxml"));
        loader.setResources(ResourceBundle.getBundle("bundles.locale", new Locale("en")));

        Parent fxmlMain = loader.load();
        LoginController loginController = loader.getController();
        loginController.setMainStage(primaryStage);
        loginController.setLogger(new ConsoleLogger());

//        Parent fxmlMain = loader.load();
//        RegisterController registerController = loader.getController();
//        registerController.setMainStage(primaryStage);
//        registerController.setLogger(new ConsoleLogger());

        Scene scene = new Scene(fxmlMain, UIConstants.loginWindowWidth, UIConstants.loginWindowHeight);
        //primaryStage.setTitle(loader.getResources().getString("title.name.login"));
        primaryStage.setMinWidth(280);
        primaryStage.setMinHeight(150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
