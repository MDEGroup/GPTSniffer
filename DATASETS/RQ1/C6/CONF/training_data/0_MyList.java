public interface MyList<E> {
    
    
    public boolean add(E e);
    
    
    public void add(int index, E e);
    
    
    public void clear();
    
    
    public boolean contains(E e);
    
    
    public E get(int index);
    
    
    
    public int indexOf(E e);
    
    
    public boolean isEmpty();
    
    
    
    public int lastIndexOf(E e);
    
    
    
    
    public boolean remove(E e);
    
    
    
    
    public E remove(int index);
    
    
    
    public E set(int index, E e);
    
    
    public int size();
    
    
    
    public boolean addAll(MyList<? extends E> otherList);
    
    
    
    public boolean removeAll(MyList<?> otherList);
    
    
    
    public boolean retainAll(MyList<?> otherList);
    
}