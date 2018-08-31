package digitalclockjp3;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Simple digital clock mostly from Internet code I found in a reply at
 * https://stackoverflow.com/questions/13227809/displaying-changing-values-in-javafx-label
 *
 * John Phillips on 4/25/2018 ...
 */
public class DigitalClockJP3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new DigitalClock(), 1600, 900));
        stage.setFullScreen(true);
        stage.show();
    }
}

class DigitalClock extends Label {

    public DigitalClock() {
        this.setStyle("-fx-font-family:'mono';-fx-font-size:650px;-fx-text-fill:#f00;-fx-background-color:#000;");
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0),
                event -> setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm")))),
                new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}
