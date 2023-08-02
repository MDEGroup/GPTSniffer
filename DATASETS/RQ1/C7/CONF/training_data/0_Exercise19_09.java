public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
    quickSort(list, 0, list.size() - 1);
}

private static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int left, int right) {
    if (left < right) {
        int pivotIndex = partition(list, left, right);
        quickSort(list, left, pivotIndex - 1);
        quickSort(list, pivotIndex + 1, right);
    }
}

private static <E extends Comparable<E>> int partition(ArrayList<E> list, int left, int right) {
    E pivot = list.get(right);
    int i = left - 1;
    for (int j = left; j < right; j++) {
        if (list.get(j).compareTo(pivot) <= 0) {
            i++;
            swap(list, i, j);
        }
    }
    swap(list, i + 1, right);
    return i + 1;
}

private static <E> void swap(ArrayList<E> list, int i, int j) {
    E temp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, temp);
}
