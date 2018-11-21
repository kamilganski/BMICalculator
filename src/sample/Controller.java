package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;

import java.awt.*;
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

            Double bmi = w * (h * h);

            result.setText(String.format("%.2f", bmi));
        } catch(NumberFormatException e) {
            weight.setText("Wpisz poprawną wartość");
            weight.selectAll();
            weight.requestFocus();
            height.setText("Wpisz poprawną wartość");
            height.selectAll();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
