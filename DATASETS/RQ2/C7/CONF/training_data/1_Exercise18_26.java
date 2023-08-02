




public class nan {
    
    private GameCell[][] board = new GameCell[8][8];

    private final double WIDTH = 400;
    private final double HEIGHT = 400;


    private final Button findButton = new Button("Find Path");
    private final Button clearButton = new Button("Clear Path");
    private final Label mainLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                gridPane.add(board[i][j] = new GameCell(), j, i);
            }
        }

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        HBox.setMargin(findButton, new Insets(5, 5, 10, 5));
        HBox.setMargin(clearButton, new Insets(5, 5, 10, 5));

        hBox.getChildren().addAll(findButton, clearButton);

        BorderPane pane = new BorderPane();
        pane.setTop(mainLabel);
        BorderPane.setAlignment(mainLabel, Pos.CENTER);
        pane.setCenter(gridPane);
        pane.setBottom(hBox);
        BorderPane.setMargin(gridPane, new Insets(5, 5, 5, 5));

        Scene scene = new Scene(pane, WIDTH + 15, HEIGHT + 80);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        findButton.setOnAction(e -> findPath());
        clearButton.setOnAction(e -> clear());
    }

    public void findPath() {
        if (findPath(0, 0)) {
            mainLabel.setText("path found");
        } else {
            mainLabel.setText("No legal path exists");
        }
    }

    public boolean findPath(int row, int col) {
        board[row][col].visit();

        if ((col == 7) && (row == 7)) {
            board[row][col].select();
            return true;
        }

        if ((row > 0) && !board[row - 1][col].isMarked() &&
                !board[row - 1][col].blocked() && !board[row - 1][col].visited()) {
            block(row, col);

            if (findPath(row - 1, col)) {
                board[row][col].select();
                return true;
            }

            unblock(row, col);
        }

        if ((row < 7) && !board[row + 1][col].isMarked() &&
                !board[row + 1][col].blocked() && !board[row + 1][col].visited()) {
            block(row, col);

            if (findPath(row + 1, col)) {
                board[row][col].select();
                return true;
            }

            unblock(row, col);
        }

        if ((col > 0) && !board[row][col - 1].isMarked() &&
                !board[row][col - 1].blocked() && !board[row][col - 1].visited()) {
            block(row, col);
            if (findPath(row, col - 1)) {
                board[row][col].select();
                return true;
            }

            unblock(row, col);
        }

        if ((col < 7) && !board[row][col + 1].isMarked() &&
                !board[row][col + 1].blocked() && !board[row][col + 1].visited()) {
            block(row, col);
            if (findPath(row, col + 1)) {
                board[row][col].select();
                return true;
            }

            unblock(row, col);
        }

        return false;
    }

    public void block(int row, int col) {
        if (row > 0) {
            board[row - 1][col].block();
        }

        if (row < 7) {
            board[row + 1][col].block();
        }

        if (col > 0) {
            board[row][col - 1].block();
        }

        if (col < 7) {
            board[row][col + 1].block();
        }
    }

    public void unblock(int row, int col) {
        if (row > 0) {
            board[row - 1][col].unblock();
        }

        if (row < 7) {
            board[row + 1][col].unblock();
        }

        if (col > 0) {
            board[row][col - 1].unblock();
        }

        if (col < 7) {
            board[row][col + 1].unblock();
        }
    }

    public void clear() {
        for (GameCell[] gameCells : board) {
            for (GameCell gameCell : gameCells) {
                gameCell.unselect();
            }
        }
    }

    class GameCell extends StackPane {
        private boolean visited = false;
        private boolean blocked = false;

        private boolean selected = false;

        double width = WIDTH / 8;
        double height = HEIGHT / 8;
        private Rectangle rectangle = new Rectangle(0, 0, width, height);

        Line line1 = new Line(0, 0, width, height);
        Line line2 = new Line(width, 0, 0, height);

        public GameCell() {
            this.getChildren().add(rectangle);
            rectangle.setFill(Color.WHITE);
            rectangle.setStroke(Color.BLACK);

            this.setOnMousePressed(e -> {
                selected = !selected;
                if (selected) {
                    mark();
                } else {
                    unmark();
                }
            });
        }

        public void mark() {
            this.getChildren().addAll(line1, line2);
        }

        public void unmark() {
            this.getChildren().remove(line1);
            this.getChildren().remove(line2);
        }

        public boolean isMarked() {
            return selected;
        }

        public void visit() {
            visited = true;
        }

        public boolean visited() {
            return visited;
        }

        public boolean blocked() {
            return blocked;
        }

        public void block() {
            blocked = true;
        }

        public void unblock() {
            blocked = false;
        }

        public void select() {
            rectangle.setFill(Color.RED);
        }

        public void unselect() {
            rectangle.setFill(Color.WHITE);
            blocked = false;
            visited = false;
        }
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}
