/**
 * Welcome to the HTreeDrawer program!
 * This program draws an H-tree fractal of a specified order.
 * Author: [Your Name]
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class HTreeDrawer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Get the order of the H-tree from the user (assuming it's provided as a command-line argument)
        int order = 3; // Set a default order for simplicity

        // Create the HTreePane
        HTreePane hTreePane = new HTreePane(order);

        // Create a scene and set it in the stage
        Scene scene = new Scene(hTreePane, 400, 400);
        primaryStage.setTitle("H-Tree Drawer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // HTreePane class
    private static class HTreePane extends Pane {
        private int order;

        public HTreePane(int order) {
            this.order = order;
            setPrefSize(400, 400);
            drawHTree(getWidth() / 2, getHeight() / 2, order);
        }

        private void drawHTree(double x, double y, int order) {
            if (order == 0) {
                return;
            }

            // Calculate line length
            double lineLength = 50 * order;

            // Draw H
            drawH(x, y, lineLength);

            // Recursive calls for the four endpoints
            drawHTree(x - lineLength / 2, y - lineLength / 2, order - 1);
            drawHTree(x + lineLength / 2, y - lineLength / 2, order - 1);
            drawHTree(x - lineLength / 2, y + lineLength / 2, order - 1);
            drawHTree(x + lineLength / 2, y + lineLength / 2, order - 1);
        }

        private void drawH(double x, double y, double length) {
            // Draw horizontal line
            Line horizontalLine = new Line(x - length / 2, y, x + length / 2, y);

            // Draw vertical lines
            Line leftVerticalLine = new Line(x - length / 2, y - length / 2, x - length / 2, y + length / 2);
            Line rightVerticalLine = new Line(x + length / 2, y - length / 2, x + length / 2, y + length / 2);

            // Add lines to the pane
            getChildren().addAll(horizontalLine, leftVerticalLine, rightVerticalLine);
        }
    }
}
