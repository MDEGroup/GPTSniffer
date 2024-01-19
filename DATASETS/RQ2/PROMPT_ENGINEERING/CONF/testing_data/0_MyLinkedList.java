public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Create a default list
     */
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Create a list from an array of objects
     */
    public MyLinkedList(E[] array) {
        for (E element : array) {
            add(element);
        }
    }

    /**
     * Add a new element at the end of this list
     */
    public void add(E element) {
        Node<E> newNode = new Node<>(element, null);

        if (size == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }

        tail = newNode;
        size++;
    }

    /**
     * Return the last element in the list
     */
    public E getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty");
        }

        return tail.data;
    }

    /**
     * Contains method
     */
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    /**
     * Get method
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * IndexOf method
     */
    public int indexOf(E element) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (element.equals(current.data)) {
                return i;
            }
            current = current.next;
        }

        return -1;
    }

    /**
     * LastIndexOf method
     */
    public int lastIndexOf(E element) {
        Node<E> current = head;
        int lastIndex = -1;

        for (int i = 0; i < size; i++) {
            if (element.equals(current.data)) {
                lastIndex = i;
            }
            current = current.next;
        }

        return lastIndex;
    }

    /**
     * Set method
     */
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E oldElement = current.data;
        current.data = element;

        return oldElement;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5};
        MyLinkedList<Integer> myList = new MyLinkedList<>(array);

        System.out.println("Last Element: " + myList.getLast());
        System.out.println("Contains 3: " + myList.contains(3));
        System.out.println("Element at index 2: " + myList.get(2));
        System.out.println("Index of 4: " + myList.indexOf(4));
        System.out.println("Last Index of 2: " + myList.lastIndexOf(2));

        myList.set(1, 10);

        System.out.println("After setting index 1 to 10: " + myList.get(1));
    }
}
