package ch_24.resources;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0; // The size of the list

    
    protected MyAbstractList() {
    }

    
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    
    @Override
    public void add(E e) {
        add(size, e);
    }

    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    
    @Override
    public int size() {
        return size;
    }


    
    @Override
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else
            return false;
    }

    /*---------------------------------------------  Exercise24_01 ---------------------------------------------------*/

    
    @Override
    public boolean addAll(MyList<E> otherList) {
        int startSize = size;
        for (E e : otherList) {
            if (!contains(e)) {
                add(e);
            }
        }
        return size == startSize;
    }

    
    @Override
    public boolean removeAll(MyList<E> otherList) {
        boolean changed = false;
        for (E e : otherList) {
            boolean removed = remove(e);
            if (removed) {
                changed = true;
            }
        }
        return changed;
    }

    
    @Override
    public boolean retainAll(MyList<E> otherList) {
        boolean changed = false;
        for (E e : this) {
            if (!otherList.contains(e)) {
                remove(indexOf(e));
                changed = true;
            }
        }
        return changed;
    }
}