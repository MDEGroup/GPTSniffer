public class StackOfIntegers { private int[] elements; private int size; private int capacity;   public StackOfIntegers() {  this(16); }   public StackOfIntegers(int capacity) {  this.capacity = capacity;  elements = new int[capacity]; }   public void push(int value) {  if (size >= capacity) {   