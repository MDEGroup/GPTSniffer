import java.util.Arrays;

public class ArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] elements;
    private int size;

    public ArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        elements[index] = element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    public boolean remove(Object obj) {
        for (int i = 0; i < size; i++) {
            if (obj == null ? elements[i] == null : obj.equals(elements[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 2);
        }
    }

    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(elements[i]).append(", ");
        }
        sb.append(elements[size - 1]).append("]");
        return sb.toString();
    }
}


public class ArrayListExample {
    public static void main(String[] args) {
        
        ArrayList<String> myArrayList = new ArrayList<String>();
        
        
        myArrayList.add("apple");
        myArrayList.add("banana");
        myArrayList.add("cherry");
        
        
        System.out.println("Initial ArrayList: " + myArrayList);
        
        
        myArrayList.add(1, "orange");
        System.out.println("ArrayList after adding 'orange' at index 1: " + myArrayList);
        
        
        myArrayList.remove(2);
        System.out.println("ArrayList after removing element at index 2: " + myArrayList);
        
        
        String element = myArrayList.get(0);
        System.out.println("Element at index 0: " + element);
        
        
        int size = myArrayList.size();
        System.out.println("Size of ArrayList: " + size);
    }
}


