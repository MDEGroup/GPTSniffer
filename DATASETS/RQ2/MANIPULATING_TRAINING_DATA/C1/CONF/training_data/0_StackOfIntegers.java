public class StackOfIntegers {
   private int[] elements;
   private int size;
   private int capacity;
   
   /**
    * Construct a stack with the default capacity 16
    */
   public StackOfIntegers() {
      this(16);
   }
   
   /**
    * Construct a stack with the specified maximum capacity
    */
   public StackOfIntegers(int capacity) {
      this.capacity = capacity;
      elements = new int[capacity];
   }
   
   /**
    * Push a new integer to the top of the stack
    */
   public void push(int value) {
      if (size >= capacity) {
         // create a new array with twice the current capacity
         int[] newElements = new int[capacity * 2];
         // copy the contents of the current array to the new array
         System.arraycopy(elements, 0, newElements, 0, size);
         // assign the reference of the new array to the current array in the stack
         elements = newElements;
         // update the capacity
         capacity *= 2;
      }
      elements[size++] = value;
   }
   
   /**
    * Return and remove the top element from the stack
    */
   public int pop() {
      if (size == 0) {
         throw new EmptyStackException();
      }
      return elements[--size];
   }
   
   /**
    * Return the top element from the stack
    */
   public int peek() {
      if (size == 0) {
         throw new EmptyStackException();
      }
      return elements[size - 1];
   }
   
   /**
    * Test whether the stack is empty
    */
   public boolean empty() {
      return size == 0;
   }
   
   /**
    * Return the number of elements in the stack
    */
   public int getSize() {
      return size;
   }
}
