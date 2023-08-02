
public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        System.out.print("Enter ten integers: ");
        for (int i = 0; i < 10; i++) {
            list.add(input.nextInt());
        }
        removeDuplicate(list);
        System.out.print("The distinct integers are");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> distinctList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            if (!distinctList.contains(number)) {
                distinctList.add(number);
            }
        }
        list.clear();
        for (int i = 0; i < distinctList.size(); i++) {
            list.add(distinctList.get(i));
        }
    }
}
