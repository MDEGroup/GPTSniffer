









public class nan {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(4, 7, "Yellow", true);
        Rectangle rectangle2 = new Rectangle(4, 7, "Blue", false);

        System.out.println("\nRectangle 1:\n " + rectangle1.toString()
                + "\n\nand\n" + "\nRectangle 2: \n" + rectangle2.toString());

        System.out.println("\nAre they equal? " + rectangle1.equals(rectangle2));


    }

}
