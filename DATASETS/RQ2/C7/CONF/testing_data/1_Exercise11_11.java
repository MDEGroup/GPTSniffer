



public class Circle2DGenerator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter five integers: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }

        sort(list);
        System.out.print("The numbers in increasing order: ");
        System.out.print("\n" + list.toString());
        in.close();
    }

    public static void sort(ArrayList<Integer> list) {
        boolean loop = true;
        while (loop) {
            loop = false; 
            for (int n = 0; n < list.size(); n++) {
                for (int i = n; i < list.size(); i++) {
                    if (!(i == n)) {
                        if (list.get(n) > list.get(i)) {
                            loop = true; 
                            swapElements(list, n, i);
                        }

                    }
                }
            }

        }


    }

    static void swapElements(ArrayList<Integer> list, int idx1, int idx2) {
        Integer temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
}
