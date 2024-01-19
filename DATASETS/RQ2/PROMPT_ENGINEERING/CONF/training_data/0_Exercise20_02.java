import java.util.LinkedList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class LinkedListGUI extends Application {
    private LinkedList<Integer> list = new LinkedList<>();
    private Set<Integer> set = new HashSet<>(); // used to store unique values

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10));

        // Text area to display the list
        TextArea taList = new TextArea();
        taList.setEditable(false);
        taList.setWrapText(true);
        pane.setCenter(taList);

        // HBox to hold the input controls
        HBox hbInput = new HBox(10);
        hbInput.setAlignment(Pos.CENTER);
        Label lblNumber = new Label("Number:");
        TextField tfNumber = new TextField();
        tfNumber.setPrefColumnCount(3);
        Button btnAdd = new Button("Add");
        hbInput.getChildren().addAll(lblNumber, tfNumber, btnAdd);
        pane.setBottom(hbInput);

        // HBox to hold the sort, shuffle, and reverse buttons
        HBox hbButtons = new HBox(10);
        hbButtons.setAlignment(Pos.CENTER);
        Button btnSort = new Button("Sort");
        Button btnShuffle = new Button("Shuffle");
        Button btnReverse = new Button("Reverse");
        hbButtons.getChildren().addAll(btnSort, btnShuffle, btnReverse);
        pane.setTop(hbButtons);

        // Event handlers for the buttons
        btnAdd.setOnAction(e -> {
            String text = tfNumber.getText().trim();
            if (!text.isEmpty()) {
                try {
                    int number = Integer.parseInt(text);
                    if (set.add(number)) { // add only if not already in the list
                        list.add(number);
                        displayList(taList);
                    }
                } catch (NumberFormatException ex) {
                    // ignore non-integer input
                }
                tfNumber.clear();
            }
        });

        btnSort.setOnAction(e -> {
            Collections.sort(list);
            displayList(taList);
        });

        btnShuffle.setOnAction(e -> {
            Collections.shuffle(list);
            displayList(taList);
        });

        btnReverse.setOnAction(e -> {
            Collections.reverse(list);
            displayList(taList);
        });

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Linked List GUI");
        primaryStage.show();
    }

    // Updates the text area to display the current list
    private void displayList(TextArea taList) {
        taList.setText(list.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
