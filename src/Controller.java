import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    public Button startButton;
    public Label startedLabel;

    public void onStartAction(ActionEvent actionEvent) {
        startedLabel.setText("Started");
        startButton.setDisable(true);
    }
}
