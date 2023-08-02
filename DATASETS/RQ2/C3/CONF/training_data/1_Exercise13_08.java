


public class Exercise13_08 {

    public static void main(String[] args) throws CloneNotSupportedException {

        MyStack start = new MyStack();

        start.push(new String("One"));
        start.push(new String("Two"));
        start.push(new String("Three"));

        MyStack cloned = (MyStack) start.clone();
        System.out.println("Is the cloned stack a shallow copy of the starting stack?");
        System.out.println(cloned == start);
        System.out.println("\nCloned " + cloned.toString());
        System.out.println("\nOriginal " + start.toString());
    }

}
