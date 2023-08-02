public class MyLinkedList<E> implements MyList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public MyLinkedList() {
    }

    public MyLinkedList(E[] elements) {
        for (E element : elements) {
            add(element);
        }
    }

    public E getLast() {
        if (size == 0) {
            return null;
        } else {
            return tail.element;
        }
    }

    @Override
    public boolean contains(E e) {
        Node<E> current = head;
        while (current != null) {
            if (e.equals(current.element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public int indexOf(E e) {
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> current = head;
        int lastIndex = -1;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) {
                lastIndex = i;
            }
            current = current.next;
        }
        return lastIndex;
    }

    @Override
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldElement = current.element;
        current.element = e;
        return oldElement;
    }

    // Other methods from MyList interface

}
