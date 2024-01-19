// This is a program to add and remove numbers from a queue

// First, let's import the necessary libraries
import java.util.LinkedList;
import java.util.Queue;

// Now, let's create our class
public class NumberQueueProgram {

    public static void main(String[] args) {
        
        // Create a queue to hold our numbers
        Queue<Integer> numberQueue = new LinkedList<Integer>();
        
        // Let's add numbers from 1 to 20 into the queue
        for (int i = 1; i <= 20; i++) {
            numberQueue.add(i); // We are adding the number 'i' to the queue
        }
        
        // Now, let's remove and display these numbers
        System.out.println("Removing and displaying numbers from the queue:");
        while (!numberQueue.isEmpty()) {
            int removedNumber = numberQueue.poll(); // We are removing a number from the queue
            System.out.println("Removed number: " + removedNumber);
        }
    }
}