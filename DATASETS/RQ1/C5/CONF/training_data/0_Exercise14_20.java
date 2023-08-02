import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

public class ArrowLine {
    public static void drawArrowLine(double startX, double startY,
                                     double endX, double endY, Pane pane) {
        double length = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
        double cos = (endX - startX) / length;
        double sin = (endY - startY) / length;
        double x3 = endX + (-10 * cos - 5 * sin);
        double y3 = endY + (-10 * sin + 5 * cos);
        double x4 = endX + (-10 * cos + 5 * sin);
        double y4 = endY + (-10 * sin - 5 * cos);
        Line line = new Line(startX, startY, endX, endY);
        Polygon arrowHead = new Polygon(endX, endY, x3, y3, x4, y4);
        pane.getChildren().addAll(line, arrowHead);
    }
}
