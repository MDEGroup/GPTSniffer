public static <E extends Comparable<E>> void mergeSort(E[] list) {
    if (list.length > 1) {
        
        int mid = list.length / 2;
        E[] left = Arrays.copyOfRange(list, 0, mid);
        E[] right = Arrays.copyOfRange(list, mid, list.length);

        
        mergeSort(left);
        mergeSort(right);

        
        merge(left, right, list);
    }
}

private static <E extends Comparable<E>> void merge(E[] left, E[] right, E[] list) {
    int i = 0; 
    int j = 0; 
    int k = 0; 

    while (i < left.length && j < right.length) {
        if (left[i].compareTo(right[j]) <= 0) {
            list[k++] = left[i++];
        } else {
            list[k++] = right[j++];
        }
    }

    
    while (i < left.length) {
        list[k++] = left[i++];
    }

    
    while (j < right.length) {
        list[k++] = right[j++];
    }
}

public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
    if (list.length > 1) {
        
        int mid = list.length / 2;
        E[] left = Arrays.copyOfRange(list, 0, mid);
        E[] right = Arrays.copyOfRange(list, mid, list.length);

        
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        
        merge(left, right, list, comparator);
    }
}

private static <E> void merge(E[] left, E[] right, E[] list, Comparator<? super E> comparator) {
    int i = 0; 
    int j = 0; 
    int k = 0; 

    while (i < left.length && j < right.length) {
        if (comparator.compare(left[i], right[j]) <= 0) {
            list[k++] = left[i++];
        } else {
            list[k++] = right[j++];
        }
    }

    
    while (i < left.length) {
        list[k++] = left[i++];
    }

    
    while (j < right.length) {
        list[k++] = right[j++];
    }
}
