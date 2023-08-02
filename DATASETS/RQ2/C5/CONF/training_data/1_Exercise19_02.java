

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class nan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter five String values seperated by space: ");
        String[] input = in.nextLine().split(" ");
        ArrayListGenericStack<String> stack = new ArrayListGenericStack<>();
        for (String s : input) {
            stack.push(s);
        }
        in.close();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}



class ArrayListGenericStack<E> extends ArrayList<E> {

    public int getSize() {
        return size();
    }

    public E peek() {
        return get(getSize() - 1);
    }

    public Object push(E o) {
        add(o);
        return o;
    }

    public Object pop() {
        Object o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: " + Arrays.toString(super.toArray());
    }
}

