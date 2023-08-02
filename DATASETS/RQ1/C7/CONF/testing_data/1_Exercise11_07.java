



public class nan{
    public static void main(String[] args) {
        ArrayList<Integer> test = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            test.add((int) (1 + Math.random() * 99));
        }
        System.out.println("Initial List = " + test.toString());
        ArrayList<Integer> initialList = new ArrayList<>();
        initialList.addAll(test);

        shuffle(test);

        System.out.println("Shuffled List = " + test.toString());

        System.out.println("TEST: Values in shuffled list = values in initial list = " + runTest(test, initialList));
    }

    private static String runTest(ArrayList<Integer> test, ArrayList<Integer> initialList) {
        for (Integer integer : test) {
            if (!initialList.contains(integer)) {
                return "False";
            }
        }
        return "True";
    }

    public static void shuffle(ArrayList<Integer> list) {
        int upperBound = list.size() - 1;
        Random random = new Random();
        int shuffles = 0;
        Integer i = list.remove(random.nextInt(upperBound));
        while (shuffles++ < 100) {
            i = list.set(random.nextInt(upperBound), i);
        }
        list.add(upperBound, i);
    }
}
