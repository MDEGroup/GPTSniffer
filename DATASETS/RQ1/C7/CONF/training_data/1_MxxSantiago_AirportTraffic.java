
public class AirportTraffic {
    private static final int PLANES_PER_RUNWAY = 5;
    private static final int RUNWAYS = 3;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int planeIdCounter = 1;

    public static void main(String[] args) {
        Queue<Integer>[] runways = new Queue[RUNWAYS];
        Queue<Integer> planesQueue = new LinkedList<>();
        boolean isProgramRunning = true;

        for (int i = 0; i < RUNWAYS; i++) runways[i] = new LinkedList<>();

        while (isProgramRunning) {
            int selectedOption = readUserOption();

            switch (selectedOption) {
                case 1 -> enterPlane(runways, planesQueue, planeIdCounter++);
                case 2 -> removePlane(runways, planesQueue);
                case 3 -> showStatistics(runways);
                case 4 -> isProgramRunning = false;
            }
        }
    }

    private static int readUserOption() {
        System.out.println("\n1. Enter plane");
        System.out.println("2. Remove plane");
        System.out.println("3. Show statistics");
        System.out.println("4. Quit");
        System.out.print("\nOption: ");

        return Stream.generate(SCANNER::nextInt)
                .filter(option -> option >= 1 && option <= 4)
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Invalid option. Please choose again.");
                    return readUserOption();
                });
    }

    private static void enterPlane(Queue<Integer>[] runways, Queue<Integer> planesQueue, int planeId) {
        planesQueue.add(planeId);
        System.out.printf("Plane %d entered queue\n", planeId);

        while (!planesQueue.isEmpty()) {
            int nextPlaneId = planesQueue.peek();
            OptionalInt selectedRunway = IntStream.range(0, RUNWAYS)
                    .filter(i -> runways[i].size() < PLANES_PER_RUNWAY)
                    .findFirst();

            if (selectedRunway.isPresent()) {
                int runwayIndex = selectedRunway.getAsInt();
                runways[runwayIndex].add(nextPlaneId);
                planesQueue.remove();
                System.out.printf("Plane %d landed on runway %d\n", nextPlaneId, runwayIndex + 1);
            } else {
                System.out.println("All runways are full");
                break;
            }
        }
    }

    private static void removePlane(Queue<Integer>[] runways, Queue<Integer> planesQueue) {
        System.out.println("Enter the ID of the plane to remove:");
        int planeToRemove = SCANNER.nextInt();

        boolean removedFromRunway = IntStream.range(0, RUNWAYS).anyMatch(i -> runways[i].remove(planeToRemove));
        if (removedFromRunway) {
            System.out.printf("Plane %d removed from runway %d\n", planeToRemove, Arrays.asList(runways).indexOf(runways[0]) + 1);
        } else if (planesQueue.remove(planeToRemove)) {
            System.out.printf("Plane %d removed from queue\n", planeToRemove);
        } else {
            System.out.printf("Plane %d not found\n", planeToRemove);
        }
    }

    public static void showStatistics(Queue<Integer>[] runways) {
        int[] runwaySizes = Arrays.stream(runways).mapToInt(Queue::size).toArray();
        int minIndex = IntStream.range(0, runwaySizes.length)
                .reduce((i, j) -> runwaySizes[i] < runwaySizes[j] ? i : j)
                .orElse(0);
        int maxIndex = IntStream.range(0, runwaySizes.length)
                .reduce((i, j) -> runwaySizes[i] > runwaySizes[j] ? i : j)
                .orElse(0);

        System.out.println("Current airport statistics:");
        IntStream.range(0, runwaySizes.length).forEach(i -> System.out.printf("Runway %d size: %d\n", i + 1, runwaySizes[i]));
        System.out.println("Runway with the least traffic: " + (minIndex + 1));
        System.out.println("Runway with the most traffic: " + (maxIndex + 1));
        double averageTraffic = Arrays.stream(runwaySizes).average().orElse(0);
        System.out.println("Average traffic per runway: " + averageTraffic);
    }
}
