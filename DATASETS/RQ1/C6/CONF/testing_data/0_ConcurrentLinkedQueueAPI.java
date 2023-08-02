import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentLinkedQueue<T> {
    private static class Node<T> {
        private final T item;
        private final AtomicReference<Node<T>> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = new AtomicReference<>(next);
        }
    }

    private final AtomicReference<Node<T>> head;
    private final AtomicReference<Node<T>> tail;

    public ConcurrentLinkedQueue() {
        Node<T> dummy = new Node<>(null, null);
        this.head = new AtomicReference<>(dummy);
        this.tail = new AtomicReference<>(dummy);
    }

    public void offer(T item) {
        if (item == null) {
            throw new NullPointerException("Cannot add null item to queue");
        }
        Node<T> newNode = new Node<>(item, null);
        Node<T> prevTail = tail.getAndSet(newNode);
        prevTail.next.set(newNode);
    }

    public T poll() {
        Node<T> oldHead;
        Node<T> newHead;
        do {
            oldHead = head.get();
            newHead = oldHead.next.get();
            if (newHead == null) {
                return null;
            }
        } while (!head.compareAndSet(oldHead, newHead));
        return newHead.item;
    }

    public T peek() {
        Node<T> first = head.get().next.get();
        if (first == null) {
            return null;
        }
        return first.item;
    }

    public boolean isEmpty() {
        return head.get().next.get() == null;
    }
}

public class QueueExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        
        queue.offer("apple");
        queue.offer("banana");
        queue.offer("cherry");

        
        System.out.println("Is the queue empty? " + queue.isEmpty());

        
        String first = queue.poll();
        System.out.println("First element: " + first);

        
        String peek = queue.peek();
        System.out.println("Peeked element: " + peek);

        
        System.out.println("Queue size: " + queue.size());
    }
}


