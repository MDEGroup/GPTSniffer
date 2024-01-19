import java.util.*;

public class GuessTheCapitals {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Creating a list of states and capitals
        List<String> states = Arrays.asList("Alabama", "Alaska", "Arizona", "Arkansas", "California");
        List<String> capitals = Arrays.asList("Montgomery", "Juneau", "Phoenix", "Little Rock", "Sacramento");

        // Combining states and capitals into a map
        Map<String, String> stateCapitalMap = new HashMap<>();
        for (int i = 0; i < states.size(); i++) {
            stateCapitalMap.put(states.get(i), capitals.get(i));
        }

        // Creating a list of indices to shuffle questions
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < states.size(); i++) {
            indices.add(i);
        }

        // Shuffling the list of indices
        Collections.shuffle(indices);

        // Asking questions in a random order
        for (int index : indices) {
            String state = states.get(index);
            String capital = stateCapitalMap.get(state);

            System.out.print("What is the capital of " + state + "? ");
            String userAnswer = input.nextLine();

            if (userAnswer.trim().equalsIgnoreCase(capital)) {
                System.out.println("Your answer is correct!\n");
            } else {
                System.out.println("The correct answer should be " + capital + ".\n");
            }
        }
    }
}