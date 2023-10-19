import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {
    private ArrayList<E> list = new ArrayList<>();

    public Heap() {
    }

    public Heap(E[] objects) {
        for (E object : objects) {
            add(object);
        }
    }

    public void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            E currentElement = list.get(currentIndex);
            E parentElement = list.get(parentIndex);

            if (currentElement.compareTo(parentElement) < 0) {
                swapElements(currentIndex, parentIndex);
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public E remove() {
        if (list.isEmpty()) {
            return null;
        }

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            if (leftChildIndex >= list.size()) {
                break;
            }

            int minIndex = leftChildIndex;
            if (rightChildIndex < list.size() && list.get(rightChildIndex).compareTo(list.get(leftChildIndex)) < 0) {
                minIndex = rightChildIndex;
            }

            if (list.get(currentIndex).compareTo(list.get(minIndex)) > 0) {
                swapElements(currentIndex, minIndex);
                currentIndex = minIndex;
            } else {
                break;
            }
        }

        return removedObject;
    }

    public int getSize() {
        return list.size();
    }

    private void swapElements(int index1, int index2) {
        E temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}