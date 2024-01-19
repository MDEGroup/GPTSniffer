public class StackOfIntegers {
    private int[] elements; // This is where we store the integers
    private int capacity; // This is the maximum capacity of the stack
    private int size; // This is the current number of elements in the stack

    // Constructor with default capacity 16
    public StackOfIntegers() {
        this.capacity = 16; // Set the maximum capacity to 16
        this.elements = new int[this.capacity]; // Create an array to store the integers
        this.size = 0; // Initially, the stack is empty, so size is 0
    }

    // Constructor with specified maximum capacity
    public StackOfIntegers(int maxCapacity) {
        this.capacity = maxCapacity; // Set the maximum capacity to the specified value
        this.elements = new int[this.capacity]; // Create an array to store the integers
        this.size = 0; // Initially, the stack is empty, so size is 0
    }

    // Method to push a new integer onto the top of the stack
    public void push(int value) {
        if (size < capacity) {
            elements[size] = value; // Add the value to the stack
            size++; // Increment the size to reflect the addition
        } else {
            // If the stack is full, we need to expand it
            int[] newElements = new int[2 * capacity]; // Create a new array with double the capacity
            for (int i = 0; i < capacity; i++) {
                newElements[i] = elements[i]; // Copy the contents of the old array to the new one
            }
            elements = newElements; // Update the reference to the new array
            capacity *= 2; // Update the maximum capacity
            elements[size] = value; // Add the value to the stack
            size++; // Increment the size to reflect the addition
        }
    }

    // Method to return and remove the top element from the stack
    public int pop() {
        if (!empty()) {
            size--; // Decrement the size to remove the top element
            return elements[size]; // Return the removed element
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // Method to return the top element from the stack without removing it
    public int peek() {
        if (!empty()) {
            return elements[size - 1]; // Return the top element
        } else {
            throw new IllegalStateException("Stack is empty");
        }
    }

    // Method to check whether the stack is empty
    public boolean empty() {
        return size == 0; // Check if the size is 0 to determine if the stack is empty
    }

    // Method to return the number of elements in the stack
    public int getSize() {
        return size; // Return the current size of the stack
    }
}