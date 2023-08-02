


public class Exercise08_08 {

	private static int[][] points;
	static double shortestDist;

	static {
		points = new int[][] { { 0, 0 }, { 1, 1 }, { -1, -1 }, { 2, 2 }, { -2, -2 }, { -3, -3 }, { -4, -4 }, { 5, 5 } };
	}

	public static void main(String[] args) {

		shortestDist = distance(points[0][0], points[0][1], points[1][0], points[1][1]); 
		
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double shrtTest = distance(points[i][0], points[i][1], points[j][0], points[j][1]); 
				if (shrtTest < shortestDist) {
					shortestDist = shrtTest;
				}
			}
		}
		
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double d = distance(points[i][0], points[i][1], points[j][0], points[j][1]); 
				if (d == shortestDist) {
					System.out.println("The closest two points are (" + points[i][0] + "," + points[i][1] + ") and ("
																	+ points[j][0] + ", " + points[j][1] + ")");
				}

			}
		}
		System.out.print("Their distance is " + shortestDist);

	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}