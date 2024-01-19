

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;


public class MatchGroupingSymbols {
    static final double HEIGHT = 200;
    static final double WIDTH = 340;
    static final String BABY_NAMES_BASE_URL = "https:
    static String[] babyNamesHttpPaths;
    static final int BOY = 1;
    static final int GIRL = 3;
    static String selectedYear;
    static String selectedGender;
    static String lookupName;

    ArrayList<HashMap<String, String>> boysNames = new ArrayList<>();
    ArrayList<HashMap<String, String>> girlsNames = new ArrayList<>();


    protected ComboBox<String> comboBoxYear = new ComboBox<>();
    protected ComboBox<String> comboBoxGender = new ComboBox<>();

    protected TextField nameFieldTextField = new TextField();
    protected Button rankingButton = new Button("Find Ranking");
    protected Label displayResultLabel = new Label("");

    static {
        babyNamesHttpPaths = new String[10];
        
        for (int i = 0, year = 2001; i < 10; year++, i++) {
            babyNamesHttpPaths[i] = BABY_NAMES_BASE_URL + year + ".txt";
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        

        populateRankings(boysNames, BOY);
        populateRankings(girlsNames, GIRL);

        
        for (int i = 2001; i <= 2010; i++) {
            comboBoxYear.getItems().add(String.valueOf(i));
        }
        
        comboBoxGender.getItems().addAll("Male", "Female");
        
        comboBoxYear.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectedYear = newValue);
        
        comboBoxGender.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectedGender = newValue);
        
        nameFieldTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            lookupName = newValue;
        });
        rankingButton.setOnAction(e -> {
            findAndDisplayRank(boysNames, girlsNames);
        });


        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5, 0, 5, 0));
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(new Label("Select a year: "), 0, 0);
        gridPane.add(comboBoxYear, 1, 0);
        gridPane.add(new Label("Boy or girl?: "), 0, 1);
        gridPane.add(comboBoxGender, 1, 1);
        gridPane.add(new Label("Enter a name: "), 0, 2);
        gridPane.add(nameFieldTextField, 1, 2);
        gridPane.add(rankingButton, 1, 3);

        BorderPane pane = new BorderPane();
        pane.setCenter(gridPane);
        pane.setBottom(displayResultLabel);
        BorderPane.setAlignment(displayResultLabel, Pos.CENTER);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        AtomicBoolean runThread = new AtomicBoolean(true);
        Thread thread = new Thread(() -> {
            while (runThread.get()) {
                rankingButton.setDisable(selectedGender == null || selectedYear == null || lookupName == null || lookupName.isEmpty());
            }
        });

        thread.start();
        primaryStage.setOnCloseRequest(event -> {
            runThread.set(false);
        });
    }

    private void populateRankings(ArrayList<HashMap<String, String>> names,
                                  int gender) throws IOException {
        for (int i = 0; i < babyNamesHttpPaths.length; i++) {
            URL dataUrl = new URL(babyNamesHttpPaths[i]);
            Scanner urlScanner = new Scanner(dataUrl.openStream());
            HashMap<String, String> map = new HashMap<>();

            while (urlScanner.hasNextLine()) {
                String[] line = urlScanner.nextLine().split("\\s+"); 
                String ranking = line[0].trim();
                map.put(line[gender].trim(), ranking);
            }
            names.add(map);
            urlScanner.close();
        }
    }

    private void findAndDisplayRank(ArrayList<HashMap<String, String>> boysNames,
                                    ArrayList<HashMap<String, String>> girlsNames) {
        int mapIndex = Integer.parseInt(selectedYear.substring(2)) - 1; 
        String rank = "";
        if (selectedGender.equalsIgnoreCase("Male")) {
            HashMap<String, String> rankings = boysNames.get(mapIndex);
            rank = rankings.get(lookupName);

        } else if (selectedGender.equalsIgnoreCase("Female")) {
            HashMap<String, String> rankings = girlsNames.get(mapIndex);
            rank = rankings.get(lookupName);
        }

        displayResultLabel.setText(getUserRankResultString(rank));
    }

    private String getUserRankResultString(String rank) {
        String displayGender = selectedGender.equals("Male") ? "Boy" : "Girl";
        return displayGender + " name " + lookupName + " is ranked #" + rank + " in year " + selectedYear;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}


