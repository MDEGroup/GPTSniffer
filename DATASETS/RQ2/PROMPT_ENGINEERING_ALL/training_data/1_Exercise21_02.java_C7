



public class NumberPanel {
	public static void main(String[] args) {

		HashSet<String> words = new HashSet<>();

		File file = new File(args[0]);
		try (Scanner input = new Scanner(file)) {
		
			for (int i = 0; input.hasNext(); i++) {
				words.add(input.next());
			}

		} catch (FileNotFoundException ex) {
			System.out.println(
					"Invalid file input. Please insure you use " + "a .txt file and correct path, then, run again, ");
		}
		List<String> arrWords = new ArrayList<>(words);

		Collections.sort(arrWords);

		System.out.print(arrWords);
	}

}
