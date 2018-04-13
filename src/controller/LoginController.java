package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import utils.ServerConnector;
import utils.UIConstants;
import utils.logging.ConsoleLogger;
import utils.logging.LogType;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.logging.Logger;

import java.io.Console;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Label loginLabel;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public Button singinButton;
    public Button registerButton;

    private Stage mainStage;
    private Stage registerStage;
    private ResourceBundle resourceBundle;
    private Logger logger;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
        this.logger = ConsoleLogger.getInstance();
    }

    public void signinAction(ActionEvent actionEvent) {
        logger.log("Sing in button tapped", LogType.ACTION);
        loggingIn();
    }

    public void registerAction(ActionEvent actionEvent) {
        logger.log("Register button tapped", LogType.ACTION);

        // setting up loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/register.fxml"));
        loader.setResources(resourceBundle);

        try {
            // setting up parent of the register scene
            Parent fxmlMain = loader.load();
            RegisterController controller = loader.getController();
            controller.setMainStage(mainStage);

            Scene registerScene = new Scene(fxmlMain, UIConstants.registerWindowWidth, UIConstants.registerWindowHeight);
            mainStage.setScene(registerScene);
            mainStage.show();
        } catch (IOException e) {
            logger.log(e.getMessage(), LogType.EXCEPTION);
        }
    }

    /**
     * Method for connecting to web to utils.logging in the system
     * @return true if utils.logging in successfully, else false
     */
    private boolean loggingIn() {
        // TODO replace with login logic in web server
        ServerConnector connector = ServerConnector.getInstance();
        boolean loggedIn = connector.login(loginTextField.getText().trim(), passwordTextField.getText().trim());
        if (loggedIn) {
            logger.log("Successfully logged in", LogType.INFO);
            return true;
        }
        logger.log("Logging in failed", LogType.INFO);
        return false;
    }

    /**
     * Method for validating form data
     * @return true if all forms are fine
     */
    private boolean formValidation() {
        // TODO replace login form validation with web validation
        if (loginTextField.getText().length() > 0 || passwordTextField.getText().length() > 0) {
            return true;
        }
        return false;
    }

    // getting main stage from main class for better performance(now we don't
    // need to create new stage, just use main one)
    public void setMainStage(Stage stage) {
        this.mainStage = stage;
        this.mainStage.setTitle(resourceBundle.getString("title.name.login"));
    }
}
