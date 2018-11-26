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

    private double bmi;

    private int activeSection = 0;

    public double getBmi() {
        return bmi;
    }

    public int getActiveSection() {
        return activeSection;
    }

    @FXML
    public void handleButtonAction(ActionEvent actionEvent) {
        try {
            Double w = new Double(weight.getText());
            Double h = new Double(height.getText());

            if(h < 2.5) {
                bmi = w / (h * h);
            } else {
                bmi = (w / (h * h)) * 10000.0;
            }

            result.setText(String.format("%.2f", bmi));

            if (bmi <= 16) {
                value.setText("Starvation");
                value.setTextFill(RED);
                activeSection = 1;
            } else if (bmi > 16 && bmi <= 16.99) {
                value.setText("Emaciation");
                value.setTextFill(RED);
                activeSection = 2;
            } else if (bmi > 17 && bmi <= 18.49) {
                value.setText("Underweight");
                value.setTextFill(ORANGE);
                activeSection = 3;
            } else if (bmi > 18.5 && bmi <= 24.99) {
                value.setText("Normal");
                value.setTextFill(GREEN);
                activeSection = 4;
            } else if (bmi > 25 && bmi <= 29.99) {
                value.setText("Overweight");
                value.setTextFill(ORANGE);
                activeSection = 5;
            } else if (bmi > 30 && bmi <= 34.99) {
                value.setText("Obese");
                value.setTextFill(RED);
                activeSection = 6;
            } else if (bmi > 35 && bmi <= 39.99) {
                value.setText("Severely obese");
                value.setTextFill(RED);
                activeSection = 7;
            } else if (bmi > 40) {
                value.setText("Morbidly obese");
                value.setTextFill(RED);
                activeSection = 8;
            }
            ScaleController.markOnSection(activeSection, bmi);

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
