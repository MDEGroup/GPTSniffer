import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.Calendar;
import java.util.TimeZone;

public class ClockPane extends Pane {

    private int hour;
    private int minute;
    private int second;
    private double clockPaneWidth;
    private double clockPaneHeight;

    public ClockPane() {
        setCurrentTime();
        paintClock();
    }

    public ClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        paintClock();
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

    public double getClockPaneWidth() {
        return clockPaneWidth;
    }

    public void setClockPaneWidth(double clockPaneWidth) {
        this.clockPaneWidth = clockPaneWidth;
        paintClock();
    }

    public double getClockPaneHeight() {
        return clockPaneHeight;
    }

    public void setClockPaneHeight(double clockPaneHeight) {
        this.clockPaneHeight = clockPaneHeight;
        paintClock();
    }

    public void paintClock() {
        getChildren().clear();

        // Drawing clock circle
        Circle circle = new Circle(clockPaneWidth / 2, clockPaneHeight / 2, clockPaneWidth / 2);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().add(circle);

        // Drawing clock hands
        double centerX = clockPaneWidth / 2;
        double centerY = clockPaneHeight / 2;

        double secondLength = clockPaneWidth * 0.4;
        double secondX = centerX + secondLength * Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - secondLength * Math.cos(second * (2 * Math.PI / 60));
        Line secondHand = new Line(centerX, centerY, secondX, secondY);
        secondHand.setStroke(Color.RED);
        getChildren().add(secondHand);

        // Adding more unnecessary details like hour and minute hands
        double minuteLength = clockPaneWidth * 0.35;
        double minuteX = centerX + minuteLength * Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - minuteLength * Math.cos(minute * (2 * Math.PI / 60));
        Line minuteHand = new Line(centerX, centerY, minuteX, minuteY);
        minuteHand.setStroke(Color.BLUE);
        getChildren().add(minuteHand);

        double hourLength = clockPaneWidth * 0.3;
        double hourX = centerX + hourLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hourLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hourHand = new Line(centerX, centerY, hourX, hourY);
        hourHand.setStroke(Color.GREEN);
        getChildren().add(hourHand);

        // Adding unnecessary text details
        Text text = new Text(centerX - 8, centerY + clockPaneHeight / 2 - 8, "12");
        getChildren().add(text);
    }

    private void setCurrentTime() {
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }
}