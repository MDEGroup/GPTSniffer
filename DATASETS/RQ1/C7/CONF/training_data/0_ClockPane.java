
public class DefaultClock extends Application {
    
    private int hour;
    private int minute;
    private int second;
    
    private double width = 400;
    private double height = 400;
    
    public DefaultClock() {
        LocalTime now = LocalTime.now();
        this.hour = now.getHour();
        this.minute = now.getMinute();
        this.second = now.getSecond();
        
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            tick();
            paintClock();
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    
    private void tick() {
        second++;
        if (second >= 60) {
            second = 0;
            minute++;
            if (minute >= 60) {
                minute = 0;
                hour++;
                if (hour >= 24) {
                    hour = 0;
                }
            }
        }
    }
    
    private void paintClock() {
        double centerX = width / 2;
        double centerY = height / 2;
        double radius = Math.min(width, height) * 0.4;
        
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        
        Text[] numbers = new Text[12];
        for (int i = 0; i < 12; i++) {
            double angle = i * 30 * Math.PI / 180;
            double x = centerX + (radius - 30) * Math.sin(angle);
            double y = centerY - (radius - 30) * Math.cos(angle);
            numbers[i] = new Text(x, y, Integer.toString((i == 0) ? 12 : i));
            numbers[i].setFont(Font.font("Arial", 20));
        }
        
        Line hourHand = new Line(centerX, centerY, centerX + radius * 0.4 * Math.sin(hour * 30 * Math.PI / 180),
                centerY - radius * 0.4 * Math.cos(hour * 30 * Math.PI / 180));
        hourHand.setStrokeWidth(6);
        hourHand.setStroke(Color.BLACK);
        
        Line minuteHand = new Line(centerX, centerY, centerX + radius * 0.6 * Math.sin(minute * 6 * Math.PI / 180),
                centerY - radius * 0.6 * Math.cos(minute * 6 * Math.PI / 180));
        minuteHand.setStrokeWidth(4);
        minuteHand.setStroke(Color.BLUE);
        
        Line secondHand = new Line(centerX, centerY, centerX + radius * 0.8 * Math.sin(second * 6 * Math.PI / 180),
                centerY - radius * 0.8 * Math.cos(second * 6 * Math.PI / 180));
        secondHand.setStrokeWidth(2);
        secondHand.setStroke(Color.RED);
        
        Group group = new Group(circle, hourHand, minuteHand, secondHand);
        for (Text number : numbers) {
            group.getChildren().add(number);
        }
        
        Scene scene = new Scene(group, width, height);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
