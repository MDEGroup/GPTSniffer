public class MyLinkedList<E> extends MyAbstractList<E> {

  private Node<E> head, tail;

  /** Create a default list */
  public MyLinkedList() {
  }

  /** Create a list from an array of objects */
  public MyLinkedList(E[] objects) {
    super(objects);
  }

  /** Return the last element in the list */
  public E getLast() {
    if (size == 0) {
      return null;
    } else {
      return tail.element;
    }
  }

  /** Return true if this list contains the element e */
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

  /** Return the element from this list at the specified index */
  public E get(int index) {
    checkIndex(index);
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    return current.element;
  }

  /** Return the index of the first matching element in this list.
   * Return -1 if no match. */
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

  /** Return the index of the last matching element in this list.
   * Return -1 if no match. */
  public int lastIndexOf(E e) {
    Node<E> current = tail;
    for (int i = size - 1; i >= 0; i--) {
      if (e.equals(current.element)) {
        return i;
      }
      current = current.previous;
    }
    return -1;
  }

  /** Replace the element at the specified position in this list
   * with the specified element and return the old element. */
  public E set(int index, E e) {
    checkIndex(index);
    Node<E> current = head;
    for (int i = 0; i < index; i++) {
      current = current.next;
    }
    E oldElement = current.element;
    current.element = e;
    return oldElement;
  }

  /** Node class */
  private static class Node<E> {
    E element;
    Node<E> next;
    Node<E> previous;

    public Node(E element) {
      this.element = element;
    }
  }

}