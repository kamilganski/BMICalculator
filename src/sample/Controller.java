package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField weight;

    @FXML
    private TextField height;

    @FXML
    private RadioButton women;

    @FXML
    private RadioButton man;

    @FXML
    private Label result;

    @FXML
    public void handleButtonAction(ActionEvent actionEvent) {
        try {
            Double w = new Double(weight.getText());
            Double h = new Double(height.getText());
            Double bmi;

            if(h < 2.5) {
                bmi = w / (h * h);
            } else {
                bmi = (w / (h * h)) * 10000.0;
            }

            result.setText(String.format("%.2f", bmi));

        } catch(NumberFormatException e) {
            weight.setPromptText("Wpisz poprawną wartość");
            weight.selectAll();
            weight.requestFocus();
            height.setPromptText("Wpisz poprawną wartość");
            height.selectAll();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
