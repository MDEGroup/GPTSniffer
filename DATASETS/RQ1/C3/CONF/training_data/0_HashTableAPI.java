import java.util.LinkedList;
import java.util.ListIterator;

class HashTable {
    private LinkedList<Node>[] arr;
    private int size;

    public HashTable(int size) {
        this.size = size;
        arr = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new LinkedList<Node>();
        }
    }

    public void put(String key, String value) {
        int index = getIndex(key);
        LinkedList<Node> list = arr[index];
        ListIterator<Node> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        list.add(new Node(key, value));
    }

    public String get(String key) {
        int index = getIndex(key);
        LinkedList<Node> list = arr[index];
        ListIterator<Node> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    public void remove(String key) {
        int index = getIndex(key);
        LinkedList<Node> list = arr[index];
        ListIterator<Node> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key.equals(key)) {
                iterator.remove();
                return;
            }
        }
    }

    private int getIndex(String key) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        return index;
    }

    private class Node {
        String key;
        String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

