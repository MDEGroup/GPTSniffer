import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class FunctionPlotter extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Function Plotter");

        // Create x and y axes
        NumberAxis xAxis = new NumberAxis("x", -100, 100, 10);
        NumberAxis yAxis = new NumberAxis("f(x)", 0, 2500, 250);

        // Create a line chart to plot the function
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Function Plot: f(x) = x^2");

        // Create a series for the function plot
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("f(x) = x^2");

        // Add points to the series for the function plot
        double scaleFactor = 0.0125;
        for (int x = -100; x <= 100; x++) {
            double y = scaleFactor * x * x;
            series.getData().add(new XYChart.Data<>(x, y));
        }

        // Add the series to the line chart
        lineChart.getData().add(series);

        // Create a scene and set it for the primary stage
        Scene scene = new Scene(lineChart, 800, 600);
        primaryStage.setScene(scene);

        // Show the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}