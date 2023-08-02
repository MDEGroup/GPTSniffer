public static int getRandom(int... numbers) {
    // Create a set to store the excluded numbers
    Set<Integer> excludedNumbers = new HashSet<>();
    for (int num : numbers) {
        excludedNumbers.add(num);
    }

    // Generate a random number until a valid one is found
    Random rand = new Random();
    int num;
    do {
        num = rand.nextInt(54) + 1;
    } while (excludedNumbers.contains(num));

    return num;
}