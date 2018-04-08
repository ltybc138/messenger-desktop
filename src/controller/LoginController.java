package controller;

import utils.logging.LogType;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.logging.Logger;

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
    }

    public void signinAction(ActionEvent actionEvent) {
        logger.log("Sing in button tapped", LogType.ACTION);
    }

    public void registerAction(ActionEvent actionEvent) {
        // TODO realise goto new register window
        logger.log("Register button tapped", LogType.ACTION);
    }

    /**
     * Method for connecting to web to utils.logging in the system
     * @return true if utils.logging in successfully, else false
     */
    private boolean loggingIn() {
        // TODO replace with login logic in web server
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

    // setting the logger
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
