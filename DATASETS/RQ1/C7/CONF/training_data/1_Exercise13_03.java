



public class SortArray{
    static ArrayList<Number> testList;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        testList = new ArrayList<>();
        System.out.print("Enter five integers and five doubles: ");

        for (int i = 0; i < 5; i++) {
            Number n = in.nextInt();
            testList.add(n);
        }
        for (int i = 0; i < 5; i++) {
            Number n = in.nextDouble();
            testList.add(n);
        }
        sort(testList);
        for (Number n : testList) {
            System.out.print(n + " ");
        }

        



        in.close();
    }


    public static void sort(ArrayList<Number> list) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).doubleValue() > list.get(i + 1).doubleValue()) {
                    isSorted = false;
                    Number smallNum = list.get(i + 1);
                    list.set(i + 1, list.get(i));
                    list.set(i, smallNum);
                }
            }
        }
    }

    static ArrayList<Number> getRandomTestList() {
        ArrayList<Number> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }

    static boolean isArraySorted(ArrayList<Number> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).intValue() < list.get(i - 1).intValue()) {
                return false;
            }
        }
        return true;
    }
}
