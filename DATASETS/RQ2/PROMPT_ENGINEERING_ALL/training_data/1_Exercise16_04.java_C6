

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class MilesKilometersConverter{
    private double WIDTH = 300;
    private double HEIGHT = 100;

    @Override
    public void start(Stage primaryStage) {
        TextField mileTextField = new TextField();
        TextField kiloTextField = new TextField();
        mileTextField.setAlignment(Pos.BOTTOM_RIGHT);
        kiloTextField.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.add(new Label("Miles"), 0, 0);
        pane.add(mileTextField, 1, 0);
        pane.add(new Label("Kilometers"), 0, 1);
        pane.add(kiloTextField, 1, 1);

        
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        mileTextField.setOnAction(e -> {
            double mile = new Double(mileTextField.getText().trim()).doubleValue();
            double kilometer = mile / 0.6241;
            kiloTextField.setText(new Double(kilometer).toString());
        });

        kiloTextField.setOnAction(e -> {
            double kilometer = new Double(kiloTextField.getText().trim()).doubleValue();
            double mile = 0.6241 * kilometer;
            mileTextField.setText(new Double(mile).toString());
        });
    }
}
