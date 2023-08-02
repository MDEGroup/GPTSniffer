
public class BinaryHeap<E extends Comparable<E>> {
    private List<E> heap;

    public BinaryHeap() {
        heap = new ArrayList<>();
    }

    public void insert(E key) {
        heap.add(key);
        int i = heap.size() - 1;
        while (i > 0 && heap.get((i - 1) / 2).compareTo(heap.get(i)) > 0) {
            E temp = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, temp);
            i = (i - 1) / 2;
        }
    }

    public E delete() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        E result = heap.get(0);
        E last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            int i = 0;
            while (true) {
                int leftChild = 2 * i + 1;
                int rightChild = 2 * i + 2;
                if (leftChild >= heap.size()) {
                    break;
                }
                int minChild = leftChild;
                if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) {
                    minChild = rightChild;
                }
                if (heap.get(i).compareTo(heap.get(minChild)) > 0) {
                    E temp = heap.get(i);
                    heap.set(i, heap.get(minChild));
                    heap.set(minChild, temp);
                    i = minChild;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
