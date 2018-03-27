package windows.register;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    public TextField emailTextField;
    public TextField firstNameTextField;
    public TextField lastNameTextField;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public PasswordField confirmTextField;

    public Button registerButton;
    public Label checkerLabel;

    public void registerAction(ActionEvent actionEvent) {
        if (formValidation()) {
            checkerLabel.setText("Correct");
            registering();
        } else {
            checkerLabel.setText("Incorrect");
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
}
