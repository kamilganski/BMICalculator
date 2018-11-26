package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.*;

public class BmiController implements Initializable {

    @FXML
    private TextField weight;

    @FXML
    private TextField height;

    @FXML
    private RadioButton woman;

    @FXML
    private RadioButton man;

    @FXML
    private Label result;

    @FXML
    private Label value;

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

            if (bmi <= 16) {
                value.setText("Starvation");
                value.setTextFill(RED);
            } else if (bmi > 16 && bmi <= 16.99) {
                value.setText("Emaciation");
                value.setTextFill(RED);
            } else if (bmi > 17 && bmi <= 18.49) {
                value.setText("Underweight");
                value.setTextFill(ORANGE);
            } else if (bmi > 18.5 && bmi <= 24.99) {
                value.setText("Normal");
                value.setTextFill(GREEN);
            } else if (bmi > 25 && bmi <= 29.99) {
                value.setText("Overweight");
                value.setTextFill(ORANGE);
            } else if (bmi > 30 && bmi <= 34.99) {
                value.setText("Obese");
                value.setTextFill(RED);
            } else if (bmi > 35 && bmi <= 39.99) {
                value.setText("Severely obese");
                value.setTextFill(RED);
            } else if (bmi > 40) {
                value.setText("Morbidly obese");
                value.setTextFill(RED);
            }

        } catch(NumberFormatException e) {
            weight.setPromptText("Enter the correct value");
            weight.selectAll();
            weight.requestFocus();
            height.setPromptText("Enter the correct value");
            height.selectAll();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
