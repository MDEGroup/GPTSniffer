

import java.util.PriorityQueue;


public class nan{
    public static void main(String[] args) throws CloneNotSupportedException {
        MyPriorityQueue<String> queue = new MyPriorityQueue<>();
        queue.offer("Testing");
        queue.offer("Test");
        queue.offer("TEST");
        MyPriorityQueue<String> clonedQueue = (MyPriorityQueue<String>) (queue.clone());

        System.out.print(clonedQueue);
    }
}

class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyPriorityQueue<E> queue = new MyPriorityQueue<E>();

        for (E e : this) {
            queue.offer(e);
        }

        return queue;
    }
}