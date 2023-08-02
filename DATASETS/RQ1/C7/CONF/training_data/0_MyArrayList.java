public class MyArrayList<E> extends MyAbstractList<E> {

  public static final int INITIAL_CAPACITY = 16;

  private E[] data = (E[]) new Object[INITIAL_CAPACITY];

  
  public MyArrayList() {
  }

  
  public MyArrayList(E[] objects) {
    for (int i = 0; i < objects.length; i++)
      add(objects[i]);
  }

  
  private void ensureCapacity() {
    if (size >= data.length) {
      E[] newData = (E[]) (new Object[size * 2 + 1]);
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    }
  }

  
  public void trimToSize() {
    if (size != data.length) {
      E[] newData = (E[]) (new Object[size]);
      System.arraycopy(data, 0, newData, 0, size);
      data = newData;
    }
  }

  @Override
  public void clear() {
    data = (E[]) new Object[INITIAL_CAPACITY];
    size = 0;
  }

  @Override
  public boolean contains(E e) {
    for (int i = 0; i < size; i++)
      if (e.equals(data[i]))
        return true;

    return false;
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

    return data[index];
  }

  @Override
  public int indexOf(E e) {
    for (int i = 0; i < size; i++)
      if (e.equals(data[i]))
        return i;

    return -1;
  }

  @Override
  public int lastIndexOf(E e) {
    for (int i = size - 1; i >= 0; i--)
      if (e.equals(data[i]))
        return i;

    return -1;
  }

  @Override
  public E set(int index, E e) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

    E old = data[index];
    data[index] = e;
    return old;
  }

  @Override
  public void add(int index, E e) {
    ensureCapacity();

    for (int i = size - 1; i >= index; i--)
      data[i + 1] = data[i];

    data[index] = e;

    size++;
  }

  @Override
  public E remove(int index) {
    if (index < 0 || index >= size)
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

    E e = data[index];

    for (int j = index; j < size - 1; j++)
      data[j] = data[j + 1];

    data[size - 1] = null;

    size--;

    return e;
  }
}
