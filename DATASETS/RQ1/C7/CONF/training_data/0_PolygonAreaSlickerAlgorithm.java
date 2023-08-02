
public class PolygonAreaSlicker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of vertices in the polygon: ");
        int n = sc.nextInt();
        
        double[] x = new double[n];
        double[] y = new double[n];
        
        System.out.println("Enter the x and y coordinates of the vertices:");
        for (int i = 0; i < n; i++) {
            System.out.print("Vertex " + (i+1) + ": ");
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }
        
        double area = calculateArea(x, y, n);
        
        System.out.println("The area of the polygon is " + area);
    }
    
    private static double calculateArea(double[] x, double[] y, int n) {
        double area = 0.0;
        
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            area += x[i] * y[j] - x[j] * y[i];
        }
        
        area = Math.abs(area) / 2.0;
        
        return area;
    }
}

