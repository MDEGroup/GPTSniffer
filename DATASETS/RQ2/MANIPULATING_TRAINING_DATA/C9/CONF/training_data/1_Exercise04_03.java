package ch_04;


public class Exercise04_03 {

    static double addTwoTriangles(Triangle t1, Triangle t2) {
        return t1.area + t2.area;
    }

    public static void main(String[] args) {

        double radius = 6_371.01; // Mean radius of Planet Earth

        // Find distance between points for Triangle2D One
        double atlantaToCharlotte, charlotteToSavannah, savannahToAtlanta;

        atlantaToCharlotte = radius * Math.acos(Math.sin(-84.27822) * Math.sin(-81.5197542)
                + Math.cos(-84.2782200) * Math.cos(-81.5197542) * Math.cos(33.8901000 - 32.10815));

        charlotteToSavannah = radius * Math.acos(Math.sin(-80.95676) * Math.sin(-81.17461)
                + Math.cos(-80.95676) * Math.cos(-81.1746100) * Math.cos(35.20724 - 32.1081500));

        savannahToAtlanta = radius * Math.acos(Math.sin(-81.17461) * Math.sin(-84.27822)
                + Math.cos(-81.1746100) * Math.cos(-84.27822) * Math.cos(32.10815 - 33.8901));

        Triangle triangle1 = new Triangle(atlantaToCharlotte, charlotteToSavannah, savannahToAtlanta);
        triangle1.computeArea();

        // Find the distance need for Triangle2D two
        double savannahToOrlando, orlandoToAtlanta;

        savannahToOrlando = radius * Math.acos(Math.sin(-81.17461) * Math.sin(-81.5197542)
                + Math.cos(81.17461) * Math.cos(-81.5197542) * Math.cos(32.10815 - 28.4283959));

        orlandoToAtlanta = radius * Math.acos(Math.sin(-84.27822) * Math.sin(-81.519754)
                + Math.cos(81.17461) * Math.cos(-81.5197542) * Math.cos(33.8901000 - 28.4283959));

        Triangle triangle2 = new Triangle(savannahToOrlando, orlandoToAtlanta, savannahToAtlanta);
        triangle2.computeArea();

        double areaOfPolygon = addTwoTriangles(triangle1, triangle2);

        System.out.printf("Using the Great Circle calculation, the estimated area enclosed by "
                + "\nAtlanta, Charlotte, Savannah, and Orlando is %.4f", areaOfPolygon);

    }

}

class Triangle {

    double side1;
    double side2;
    double side3;
    double area;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    void computeArea() {
        double s = side1 + side2 + side3;
        area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    
    public double getArea() {
        return area;
    }

    
    public void setArea(double area) {
        this.area = area;
    }
}
