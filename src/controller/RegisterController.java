package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.UIConstants;
import utils.logging.LogType;
import utils.logging.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    public TextField emailTextField;
    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public PasswordField confirmTextField;

    public Button registerButton;

    private Stage mainStage;
    private ResourceBundle resourceBundle;
    private Logger logger;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
    }

    public void registerAction(ActionEvent actionEvent) {
        if (formValidation()) {
            logger.log("Register button tap", LogType.ACTION);
        } else {
            logger.log("Please, fill all the textfileds", LogType.ERROR);
        }
    }

    public void signinAction(ActionEvent actionEvent) {
        logger.log("Login button tapped", LogType.ACTION);

        // setting up loader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../fxml/login.fxml"));
        loader.setResources(resourceBundle);

        try {
            // setting up parent of the login scene
            Parent fxmlMain = loader.load();
            LoginController controller = loader.getController();
            controller.setMainStage(mainStage);
            controller.setLogger(logger);

            Scene loginScene = new Scene(fxmlMain, UIConstants.loginWindowWidth,  UIConstants.loginWindowHeight);
            mainStage.setScene(loginScene);
            mainStage.show();
        } catch (IOException e) {
            logger.log(e.getMessage(), LogType.EXCEPTION);
        }
    }

    /**
     * This method realise logic of registering
     * @return true if registration finished successfully
     */
    private boolean registering() {
        // TODO replace with web realisation of registration
        return false;
    }
    /**
     * This method validates form input
     * @return true if data is valid
     */
    private boolean formValidation() {
        // TODO replace with web realisation
        // TODO redo with better values
        if (emailTextField.getText().length() > 0 &&
                firstNameTextField.getText().length() > 0 &&
                lastNameTextField.getText().length() > 0 &&
                loginTextField.getText().length() > 0 &&
                passwordTextField.getText().length() > 0 &&
                confirmTextField.getText().length() > 0) {
            return true;
        }
        return false;
    }

    // getting main stage from main class for better performance(now we don't
    // need to create new stage, just use main one)

    public void setMainStage(Stage stage) {
        this.mainStage = stage;
        this.mainStage.setTitle(resourceBundle.getString("title.name.register"));
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
