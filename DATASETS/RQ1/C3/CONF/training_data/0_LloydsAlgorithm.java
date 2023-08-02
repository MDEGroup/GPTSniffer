import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LloydsAlgorithm {
    private static final int NUM_POINTS = 10; // number of points to generate
    private static final int NUM_ITERATIONS = 10; // number of iterations to run
    
    public static void main(String[] args) {
        // Generate initial set of points
        List<Point> points = generatePoints(NUM_POINTS);
        
        // Run Lloyd's algorithm
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            // Compute Voronoi diagram
            VoronoiDiagram voronoiDiagram = new VoronoiDiagram(points);
            
            // Compute centroid of each Voronoi cell
            List<Point> centroids = new ArrayList<>();
            for (VoronoiCell cell : voronoiDiagram.getCells()) {
                centroids.add(cell.getCentroid());
            }
            
            // Update points to be the centroids
            points = centroids;
        }
        
        // Print final set of points
        System.out.println("Final set of points:");
        for (Point point : points) {
            System.out.println(point.toString());
        }
    }
    
    /**
     * Generates a list of random points.
     */
    private static List<Point> generatePoints(int numPoints) {
        List<Point> points = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < numPoints; i++) {
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            points.add(new Point(x, y));
        }
        return points;
    }
}

