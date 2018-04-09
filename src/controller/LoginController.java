package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import utils.logging.LogType;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.logging.Logger;

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
    }

    public void signinAction(ActionEvent actionEvent) {
        logger.log("Sing in button tapped", LogType.ACTION);
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
            controller.setLogger(logger);

            Scene registerScene = new Scene(fxmlMain, 280, 420);
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
