import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class InvestmentValueCalculator extends Application {

    private TextField investmentAmountField;
    private TextField yearsField;
    private TextField annualInterestRateField;
    private TextField futureValueField;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create labels and text fields
        Label investmentAmountLabel = new Label("Investment Amount:");
        investmentAmountField = new TextField();
        investmentAmountField.setPromptText("Enter investment amount");

        Label yearsLabel = new Label("Number of Years:");
        yearsField = new TextField();
        yearsField.setPromptText("Enter number of years");

        Label annualInterestRateLabel = new Label("Annual Interest Rate:");
        annualInterestRateField = new TextField();
        annualInterestRateField.setPromptText("Enter annual interest rate");

        Label futureValueLabel = new Label("Future Value:");
        futureValueField = new TextField();
        futureValueField.setEditable(false);

        // Create Calculate button
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(e -> calculateFutureValue());

        // Create grid pane and add labels and text fields
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.add(investmentAmountLabel, 0, 0);
        gridPane.add(investmentAmountField, 1, 0);
        gridPane.add(yearsLabel, 0, 1);
        gridPane.add(yearsField, 1, 1);
        gridPane.add(annualInterestRateLabel, 0, 2);
        gridPane.add(annualInterestRateField, 1, 2);
        gridPane.add(futureValueLabel, 0, 3);
        gridPane.add(futureValueField, 1, 3);

        // Create HBox for button
        HBox hbox = new HBox(calculateButton);
        hbox.setAlignment(Pos.CENTER);

        // Create scene and add grid pane and HBox to it
        Scene scene = new Scene(new HBox(gridPane), 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Investment Value Calculator");
        primaryStage.show();
    }

    private void calculateFutureValue() {
        // Parse values from text fields
        double investmentAmount = Double.parseDouble(investmentAmountField.getText());
        int years = Integer.parseInt(yearsField.getText());
        double annualInterestRate = Double.parseDouble(annualInterestRateField.getText()) / 100;

        // Calculate future value
        double monthlyInterestRate = annualInterestRate / 12;
        double futureValue = investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);

        // Set future value text field
        futureValueField.setText(String.format("$%.2f", futureValue));
    }

    public static void main(String[] args) {
        launch(args);
    }
}