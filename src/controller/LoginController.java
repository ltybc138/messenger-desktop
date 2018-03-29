package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    public Label loginLabel;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public Button singinButton;
    public Label checkerLabel;
    public Button registerButton;

    private Stage mainStage;
    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.resourceBundle = resources;
    }

    public void signinAction(ActionEvent actionEvent) {
        if (formValidation()) {
            checkerLabel.setText("Correct");
            loggingIn();
        } else {
            checkerLabel.setText("Incorrect");
        }
    }

    /**
     * Method for connecting to web to logging in the system
     * @return true if logging in successfully, else false
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

    public void registerAction(ActionEvent actionEvent) {
        // TODO realise goto new register window
    }

    // getting main stage from main class for better performance(now we don't
    // need to create new stage, just use main one)
    public void setMainStage(Stage stage) {
        this.mainStage = stage;
    }
}
