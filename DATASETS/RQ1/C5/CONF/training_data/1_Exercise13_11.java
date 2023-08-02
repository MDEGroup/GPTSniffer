



public class OctagonClass{
    public static void main(String[] args) {
        Octagon octagon1 = new Octagon(5);
        System.out.println("Octagon1 perimeter = " + octagon1.getPerimeter() + ", area = " + octagon1.getArea());
        Octagon octagon2 = null;
        System.out.println("Cloning Octagon1 .......");
        try {
             octagon2 = octagon1.clone();
        }catch (CloneNotSupportedException cnse){
            cnse.printStackTrace();
        }

        System.out.println("octagon1.compareTo(octagon 2): " + octagon1.compareTo(octagon2));
        System.out.println("Octagon 2 area = " + octagon2.getArea() + ", perimeter = " + octagon2.getPerimeter());


    }

}
