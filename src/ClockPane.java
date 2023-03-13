import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockPane extends Pane {
  private int hour;
  private int minute;
  private int second;

  public ClockPane() {
    setCurrentTime();
  }

  public ClockPane(int hour, int minute, int second) {
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
    paintClock();
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
    paintClock();
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
    paintClock();
  }

  private void setCurrentTime() {
    Calendar time = new GregorianCalendar();

    this.hour = time.get(Calendar.HOUR_OF_DAY);
    this.minute = time.get(Calendar.MINUTE);
    this.second = time.get(Calendar.SECOND);
    paintClock();
  }

  private void paintClock() {
    double radius = Math.min(getWidth(), getHeight()) * 0.4;
    double centerX = getWidth() / 2;
    double centerY = getHeight() / 2;

    Circle circle = new Circle(centerX, centerY, radius);
    circle.setFill(Color.WHITE);
    circle.setStroke(Color.BLACK);
    Text t1 = new Text(centerX - 5, centerY - radius + 12, "12");
    Text t2 = new Text(centerX + radius - 10, centerY, "3");
    Text t3 = new Text(centerX, centerY + radius - 5, "6");
    Text t4 = new Text(centerX - radius + 5, centerY, "9");

    // Drawing second line
    double secondLength = radius * 0.69;
    double secondX = centerX + secondLength * Math.sin(second * 2 * Math.PI / 60);
    double secondY = centerY - secondLength + Math.cos(second * 2 * Math.PI / 60);
    Line secondLine = new Line(centerX, centerY, secondX, secondY);
    secondLine.setStroke(Color.RED);

    // Drawing minute line
    double minuteLength = radius * 0.65;
    double minuteX = centerX + minuteLength * Math.sin(minute * 2 * Math.PI / 60);
    double minuteY = centerY - minuteLength * Math.cos(minute * 2 * Math.PI / 60);
    Line minuteLine = new Line(centerX, centerY, minuteX, minuteY);
    minuteLine.setStroke(Color.BLUE);

    // Drawing hour line
    double hourLength = radius * 0.5;
    double hourX = centerX + hourLength * Math.sin(hour * 2 * Math.PI / 12);
    double hourY = centerY - hourLength * Math.cos(hour * 2 * Math.PI / 12);
    Line hourLine = new Line(centerX, centerY, hourX, hourY);
    hourLine.setStroke(Color.GREEN);
    hourLine.setStrokeWidth(3);

    getChildren().clear();
    getChildren().addAll(circle, t1, t2, t3, t4, secondLine, minuteLine, hourLine);
  }

  @Override
  protected void setWidth(double value) {
    super.setWidth(value);
    paintClock();
  }

  @Override
  protected void setHeight(double value) {
    super.setHeight(value);
    paintClock();
  }
}
