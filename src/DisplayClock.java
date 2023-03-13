import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class DisplayClock extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    ClockPane clock = new ClockPane();
    String time = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
    Label currentTime = new Label(time);
    BorderPane pane = new BorderPane();
    pane.setCenter(clock);
    pane.setBottom(currentTime);
    BorderPane.setAlignment(currentTime, Pos.TOP_CENTER);

    primaryStage.setScene(new Scene(pane, 400, 300));
    primaryStage.show();
  }
}