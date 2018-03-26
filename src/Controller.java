import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {

    public Label loginLabel;
    public TextField loginTextField;
    public PasswordField passwordTextField;
    public Button singinButton;
    public Label checkerLabel;

    public void signinAction(ActionEvent actionEvent) {
        if (formValidation()) {
            checkerLabel.setText("Correct");
        } else {
            checkerLabel.setText("Incorrect");
        }
    }

    private boolean formValidation() {
        if (loginTextField.getText().length() < 4 || passwordTextField.getText().length() < 8) {
            return false;
        }
        return true;
    }
}
