



public class DIsplayStudentDataPie{
    double width = 350;
    double height = 350;
    double nextSliceStart = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        double wedge20Percent = 0.2 * 360;
        double wedge10Percent = 0.1 * 360;
        double wedge30Percent = 0.3 * 360;
        double wedge40Percent = 0.4 * 360;
        double centerX = width / 2;
        double centerY = height / 2;
        double radius = 150;

        Circle circle = new Circle(centerX, centerY, radius);

        Arc projects = new Arc(centerX, centerY, circle.getRadius(), circle.getRadius(), nextSliceStart, wedge20Percent);
        nextSliceStart += wedge20Percent;
        projects.setType(ArcType.ROUND);
        projects.setFill(Color.RED);
        projects.setStroke(Color.RED);
        Text projectText = new Text(centerX + 25, centerY - 15, "Project -- 20%");


        Arc quizzes = new Arc(centerX, centerY, circle.getRadius(), circle.getRadius(), nextSliceStart, wedge10Percent);
        nextSliceStart += wedge10Percent;
        quizzes.setType(ArcType.ROUND);
        quizzes.setFill(Color.BLUE);
        quizzes.setStroke(Color.BLUE);
        Text quizText = new Text(centerX + 15, centerY - (radius + 10), "Quizzes -- 10%");


        Arc midTerms = new Arc(centerX, centerY, circle.getRadius(), circle.getRadius(), nextSliceStart,
                wedge30Percent);
        nextSliceStart += wedge30Percent;
        midTerms.setType(ArcType.ROUND);
        midTerms.setFill(Color.GREEN);
        midTerms.setStroke(Color.GREEN);
        Text midtermText = new Text(centerX - 135, centerY, "MidTerm -- 30%");

        Arc finals = new Arc(centerX, centerY, circle.getRadius(), circle.getRadius(), nextSliceStart, wedge40Percent);
        nextSliceStart += wedge40Percent;
        finals.setType(ArcType.ROUND);
        finals.setFill(Color.ORANGE);
        finals.setStroke(Color.ORANGE);
        Text finalsText = new Text(centerX + 15, centerY + (radius - 15), "Finals -- 40%");


        pane.getChildren().add(circle);
        pane.getChildren().addAll(projects, quizzes, midTerms, finals);
        pane.getChildren().addAll(projectText, quizText, midtermText, finalsText);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();
    }
}
