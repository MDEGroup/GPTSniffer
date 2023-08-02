


public class Calc extends Application {
    private static final String[][] template = {
            {"7", "8", "9", "/"},
            {"4", "5", "6", "*"},
            {"1", "2", "3", "-"},
            {"0", "c", "=", "+"}
    };

    private final Map<String, Button> accelerators = new HashMap<>();

    private final DoubleProperty stackValue = new SimpleDoubleProperty();
    private final DoubleProperty value = new SimpleDoubleProperty();

    private enum Op {NOOP, ADD, SUBTRACT, MULTIPLY, DIVIDE}

    private Op curOp = Op.NOOP;
    private Op stackOp = Op.NOOP;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final TextField screen = createScreen();
        final TilePane buttons = createButtons();

        stage.setTitle("Calc");
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        stage.setScene(new Scene(createLayout(screen, buttons)));
        stage.show();
    }

    private VBox createLayout(TextField screen, TilePane buttons) {
        final VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: chocolate; -fx-padding: 20; -fx-font-size: 20;");
        layout.getChildren().setAll(screen, buttons);
        handleAccelerators(layout);
        screen.prefWidthProperty().bind(buttons.widthProperty());
        return layout;
    }

    private void handleAccelerators(VBox layout) {
        layout.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
            Button activated = accelerators.get(keyEvent.getText());
            if (activated != null) {
                activated.fire();
            }
        });
    }

    private TextField createScreen() {
        final TextField screen = new TextField();
        screen.setStyle("-fx-background-color: aquamarine;");
        screen.setAlignment(Pos.CENTER_RIGHT);
        screen.setEditable(false);
        screen.textProperty().bind(Bindings.format("%.0f", value));
        return screen;
    }

    private TilePane createButtons() {
        TilePane buttons = new TilePane();
        buttons.setVgap(7);
        buttons.setHgap(7);
        buttons.setPrefColumns(template[0].length);
        for (String[] r : template) {
            for (String s : r) {
                buttons.getChildren().add(createButton(s));
            }
        }
        return buttons;
    }

    private Button createButton(final String s) {
        Button button = makeStandardButton(s);

        if (s.matches("[0-9]")) {
            makeNumericButton(s, button);
        } else {
            final ObjectProperty<Op> triggerOp = determineOperand(s);
            if (triggerOp.get() != Op.NOOP) {
                makeOperandButton(button, triggerOp);
            } else if ("c".equals(s)) {
                makeClearButton(button);
            } else if ("=".equals(s)) {
                makeEqualsButton(button);
            }
        }

        return button;
    }

    private ObjectProperty<Op> determineOperand(String s) {
        final ObjectProperty<Op> triggerOp = new SimpleObjectProperty<>(Op.NOOP);
        switch (s) {
            case "+" -> triggerOp.set(Op.ADD);
            case "-" -> triggerOp.set(Op.SUBTRACT);
            case "*" -> triggerOp.set(Op.MULTIPLY);
            case "/" -> triggerOp.set(Op.DIVIDE);
        }
        return triggerOp;
    }

    private void makeOperandButton(Button button, final ObjectProperty<Op> triggerOp) {
        button.setStyle("-fx-base: lightgray;");
        button.setOnAction(actionEvent -> curOp = triggerOp.get());
    }

    private Button makeStandardButton(String s) {
        Button button = new Button(s);
        button.setStyle("-fx-base: beige;");
        accelerators.put(s, button);
        button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        return button;
    }

    private void makeNumericButton(final String s, Button button) {
        button.setOnAction(actionEvent -> {
            if (curOp == Op.NOOP) {
                value.set(value.get() * 10 + Integer.parseInt(s));
            } else {
                stackValue.set(value.get());
                value.set(Integer.parseInt(s));
                stackOp = curOp;
                curOp = Op.NOOP;
            }
        });
    }

    private void makeClearButton(Button button) {
        button.setStyle("-fx-base: mistyrose;");
        button.setOnAction(actionEvent -> value.set(0));
    }

    private void makeEqualsButton(Button button) {
        button.setStyle("-fx-base: ghostwhite;");
        button.setOnAction(actionEvent -> {
            switch (stackOp) {
                case ADD -> value.set(stackValue.get() + value.get());
                case SUBTRACT -> value.set(stackValue.get() - value.get());
                case MULTIPLY -> value.set(stackValue.get() * value.get());
                case DIVIDE -> value.set(stackValue.get() / value.get());
            }
        });
    }
}
