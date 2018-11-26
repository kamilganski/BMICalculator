package sample;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ScaleController {

    public static void markOnSection(int activeSection, double bmi) {

        // sectionNumber-sectionName: 1-starvation, 2-emaciation, 3-underWeight, 4-normal, 5-overWeight, 6-obese, 7-severelyObese. 8-morbidlyObese

        Canvas canvas = new Canvas();
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(20, 330, 5, 40);
    }
}
