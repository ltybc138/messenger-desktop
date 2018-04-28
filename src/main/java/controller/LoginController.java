package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.Server;
import utils.UIConstants;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    private static Logger logger = LogManager.getLogger(LoginController.class);

    public Label loginLabel;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public Button singinButton;
    public Button registerButton;

    private Stage mainStage;
    private Stage registerStage;
    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
        logger.info("Successfully initialised");
    }

    public void signinAction(ActionEvent actionEvent) {
        logger.info("Sing in button tapped");
        loggingIn();
    }

    public void registerAction(ActionEvent actionEvent) {
        logger.info("Register button tapped");

        logger.info("Building loader");
        // setting up loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/register.fxml"));
        loader.setResources(resourceBundle);

        try {
            logger.info("Loading the loader");
            // setting up parent of the register scene
            Parent fxmlMain = loader.load();
            RegisterController controller = loader.getController();
            controller.setMainStage(mainStage);

            logger.info("Loading the \"Register\" scene\n");
            Scene registerScene = new Scene(fxmlMain, UIConstants.registerWindowWidth, UIConstants.registerWindowHeight);
            mainStage.setScene(registerScene);
            mainStage.show();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Method for connecting to web to utils.logging in the system
     * @return true if utils.logging in successfully, else false
     */
    private boolean loggingIn() {
        // TODO replace with login logic in web server
        Server connector = Server.getInstance();
        boolean loggedIn = connector.login(loginTextField.getText().trim(), passwordTextField.getText().trim());
        if (loggedIn) {
            logger.info("Successfully logged in");
            return true;
        }
        logger.info("Logging in failed");
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
