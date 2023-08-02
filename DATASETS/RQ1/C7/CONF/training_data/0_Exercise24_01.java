public abstract class MyAbstractList<E> implements MyList<E> {

  protected int size;

  protected MyAbstractList() {
  }

  protected MyAbstractList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  @Override
  public boolean addAll(MyList<E> otherList) {
    int oldSize = size;
    for (E e : otherList)
      add(e);
    return size > oldSize;
  }

  @Override
  public boolean removeAll(MyList<E> otherList) {
    int oldSize = size;
    for (E e : otherList)
      remove(e);
    return size < oldSize;
  }

  @Override
  public boolean retainAll(MyList<E> otherList) {
    int oldSize = size;
    MyList<E> tempList = new MyArrayList<>();
    for (E e : this) {
      if (otherList.contains(e))
        tempList.add(e);
    }
    clear();
    addAll(tempList);
    return size < oldSize;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(E e) {
    return indexOf(e) >= 0;
  }

  @Override
  public boolean add(E e) {
    add(size, e);
    return true;
  }

  @Override
  public void add(int index, E e) {
    if (index < 0 || index > size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    ensureCapacity();

    for (int i = size - 1; i >= index; i--)
      this.set(i + 1, this.get(i));

    this.set(index, e);

    size++;
  }

  @Override
  public E remove(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

    E e = get(index);

    for (int j = index; j < size - 1; j++)
      this.set(j, this.get(j + 1));

    this.set(size - 1, null);

    size--;

    return e;
  }

  @Override
  public int indexOf(E e) {
    for (int i = 0; i < size; i++)
      if (e.equals(get(i)))
        return i;

    return -1;
  }

  @Override
  public int lastIndexOf(E e) {
    for (int i = size - 1; i >= 0; i--)
      if (e.equals(get(i)))
        return i;

    return -1;
  }

  @Override
  public E set(int index, E e) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

    E old = get(index);
    data[index] = e;
    return old;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder("[");

    for (int i = 0; i < size; i++) {
      result.append(data[i]);
      if (i < size - 1)
        result.append(", ");
    }

    return result.toString() + "]";
  }
}
