public class TestHeap {
  public static void main(String[] args) {
    Heap<Integer> heap = new Heap<Integer>();
    heap.add(23);
    heap.add(15);
    heap.add(45);
    heap.add(37);
    heap.add(55);
    heap.add(21);
    heap.add(11);

    System.out.print("Heap nodes: ");
    while (heap.getSize() > 0) {
      System.out.print(heap.remove() + " ");
    }
  }
}
