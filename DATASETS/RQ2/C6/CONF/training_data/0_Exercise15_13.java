import javafx.application.Application;import javafx.scene.Scene;import javafx.scene.canvas.Canvas;import javafx.scene.canvas.GraphicsContext;import javafx.scene.input.MouseEvent;import javafx.scene.layout.Pane;import javafx.scene.paint.Color;import javafx.scene.shape.Rectangle;import javafx.scene.text.Font;import javafx.scene.text.Text;import javafx.stage.Stage;public class InsideRectangle extends Application {  private Rectangle rectangle;  private Text message;  @Override  public void start(Stage primaryStage) throws Exception {    