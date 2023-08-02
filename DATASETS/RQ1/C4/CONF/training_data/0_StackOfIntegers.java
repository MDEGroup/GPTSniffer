public class StackOfIntegers {
   private int[] elements;
   private int size;
   private int capacity;
   
   
   public StackOfIntegers() {
      this(16);
   }
   
   
   public StackOfIntegers(int capacity) {
      this.capacity = capacity;
      elements = new int[capacity];
   }
   
   
   public void push(int value) {
      if (size >= capacity) {
         
         int[] newElements = new int[capacity * 2];
         
         System.arraycopy(elements, 0, newElements, 0, size);
         
         elements = newElements;
         
         capacity *= 2;
      }
      elements[size++] = value;
   }
   
   
   public int pop() {
      if (size == 0) {
         throw new EmptyStackException();
      }
      return elements[--size];
   }
   
   
   public int peek() {
      if (size == 0) {
         throw new EmptyStackException();
      }
      return elements[size - 1];
   }
   
   
   public boolean empty() {
      return size == 0;
   }
   
   
   public int getSize() {
      return size;
   }
}
