
public class CommonElements {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 5, 6, 7, 8};

        Set<Integer> set1 = new HashSet<>();
        for (int i : array1) {
            set1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i : array2) {
            set2.add(i);
        }

        set1.retainAll(set2);

        System.out.println("Common elements: " + set1);
    }
}

