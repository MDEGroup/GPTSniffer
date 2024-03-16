




public class MyList {
    private final static String[] LIST_ONE_INIT_VALS = {"Tom", "George", "Peter", "Jean", "Jane"};
    private final static String[] LIST_TWO_INIT_VALS = {"Tom", "George", "Michael", "Michelle", "Daniel"};

    public static void main(String[] args) {

        MyList<String> list1 = new MyArrayList<>(LIST_ONE_INIT_VALS);
        MyList<String> list2 = new MyArrayList<>(LIST_TWO_INIT_VALS);
        System.out.println("List 1 and List 2 initial values: ");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        System.out.println("list1.addAll(list2) result: ");
        list1.addAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        list1 = new MyArrayList<>(LIST_ONE_INIT_VALS);
        list2 = new MyArrayList<>(LIST_TWO_INIT_VALS);

        System.out.println("list1.removeAll(list2) result: ");
        list1.removeAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        list1 = new MyArrayList<>(LIST_ONE_INIT_VALS);
        list2 = new MyArrayList<>(LIST_TWO_INIT_VALS);

        System.out.println("list1.retainAll(list2) result: ");
        list1.retainAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

    }
}