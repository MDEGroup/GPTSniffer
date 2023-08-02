import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private int size;
    private int capacity;
    private List<Entry<K, V>>[] table;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.table = new ArrayList[capacity];
    }

    public void put(K key, V value) {
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }

        int index = getIndex(key);

        if (table[index] == null) {
            table[index] = new ArrayList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);

        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getIndex(K key) {
        return key.hashCode() % capacity;
    }

    private void resize() {
        capacity *= 2;
        List<Entry<K, V>>[] newTable = new ArrayList[capacity];

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    int index = getIndex(entry.getKey());

                    if (newTable[index] == null) {
                        newTable[index] = new ArrayList<>();
                    }

                    newTable[index].add(entry);
                }
            }
        }

        table = newTable;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

