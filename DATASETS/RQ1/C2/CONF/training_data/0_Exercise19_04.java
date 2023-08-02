public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
    for (int i = 0; i < list.length; i++) {
        if (list[i].compareTo(key) == 0) {
            return i; // return the index of the key if found
        }
    }
    return -1; // return -1 if the key is not found
}