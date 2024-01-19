import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;

public class NumberListManager extends Application {

    private LinkedList<Integer> numberList = new LinkedList<>();
    private TextArea textArea;
    private TextField inputField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // Adding unnecessary details
        Label titleLabel = new Label("Number List Manager");
        titleLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold;");

        // Adding unnecessary details
        textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setPrefHeight(150);

        // Adding unnecessary details
        inputField = new TextField();
        inputField.setPromptText("Enter a number");

        // Adding unnecessary details
        Button addButton = new Button("Add Number");
        addButton.setOnAction(e -> addNumber());

        // Adding unnecessary details
        Button sortButton = new Button("Sort");
        sortButton.setOnAction(e -> sortList());

        // Adding unnecessary details
        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(e -> shuffleList());

        // Adding unnecessary details
        Button reverseButton = new Button("Reverse");
        reverseButton.setOnAction(e -> reverseList());

        // Adding unnecessary details
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(addButton, sortButton, shuffleButton, reverseButton);

        // Adding unnecessary details
        root.setTop(titleLabel);
        root.setCenter(textArea);
        root.setBottom(inputField);
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, 400, 250);

        primaryStage.setTitle("Number List Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Adding an unnecessary method comment
    /**
     * Add a number to the list
     */
    private void addNumber() {
        try {
            int number = Integer.parseInt(inputField.getText());
            if (!numberList.contains(number)) {
                numberList.add(number);
                updateTextArea();
                inputField.clear();
            } else {
                // Adding unnecessary details
                System.out.println("Number already exists in the list.");
            }
        } catch (NumberFormatException e) {
            // Adding unnecessary details
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }

    // Adding an unnecessary method comment
    /**
     * Sort the list in ascending order
     */
    private void sortList() {
        Collections.sort(numberList);
        updateTextArea();
    }

    // Adding an unnecessary method comment
    /**
     * Shuffle the list
     */
    private void shuffleList() {
        Collections.shuffle(numberList);
        updateTextArea();
    }

    // Adding an unnecessary method comment
    /**
     * Reverse the order of the list
     */
    private void reverseList() {
        Collections.reverse(numberList);
        updateTextArea();
    }

    // Adding an unnecessary method comment
    /**
     * Update the text area with the current list contents
     */
    private void updateTextArea() {
        StringBuilder builder = new StringBuilder();
        for (Integer number : numberList) {
            builder.append(number).append("\n");
        }
        textArea.setText(builder.toString());
    }
}
