package windows.login;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    public Label loginLabel;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public Button singinButton;
    public Label checkerLabel;
    public Button registerButton;

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
}
