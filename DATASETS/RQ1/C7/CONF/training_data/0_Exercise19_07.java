public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
    int low = 0;
    int high = list.length - 1;

    while (low <= high) {
        int mid = (low + high) / 2;
        int cmp = key.compareTo(list[mid]);

        if (cmp < 0) {
            high = mid - 1;
        } else if (cmp > 0) {
            low = mid + 1;
        } else {
            return mid;
        }
    }

    return -1;
}
