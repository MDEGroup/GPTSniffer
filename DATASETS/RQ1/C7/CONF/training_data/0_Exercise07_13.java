public static int getRandom(int... numbers) {
    
    Set<Integer> excludedNumbers = new HashSet<>();
    for (int num : numbers) {
        excludedNumbers.add(num);
    }

    
    Random rand = new Random();
    int num;
    do {
        num = rand.nextInt(54) + 1;
    } while (excludedNumbers.contains(num));

    return num;
}
