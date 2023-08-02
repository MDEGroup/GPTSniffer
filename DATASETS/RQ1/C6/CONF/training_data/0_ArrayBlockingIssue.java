import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<T> {
    private final T[] buffer;
    private final int capacity;
    private int size;
    private int head;
    private int tail;
    private final Lock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public ArrayBlockingQueue(int capacity) {
        this.buffer = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void put(T element) throws InterruptedException {
        lock.lock();
        try {
            while (size == capacity) {
                notFull.await();
            }
            buffer[tail] = element;
            tail = (tail + 1) % capacity;
            size++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            T element = buffer[head];
            head = (head + 1) % capacity;
            size--;
            notFull.signal();
            return element;
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return size;
        } finally {
            lock.unlock();
        }
    }
}


public static void main(String[] args) throws InterruptedException {
    ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    queue.put("apple");
    queue.put("banana");
    queue.put("cherry");
    System.out.println(queue.take());
    System.out.println(queue.take());
    System.out.println(queue.take());
}

