
public class MatchGroupingSymbols {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java MatchGroupingSymbols filename.java");
            System.exit(1);
        }

        String filename = args[0];
        Stack<Character> stack = new Stack<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    } else if (ch == ')' || ch == '}' || ch == ']') {
                        if (stack.isEmpty()) {
                            System.out.printf("Error: no opening symbol for %c at line %d\n", ch, lineNumber);
                            return;
                        }

                        char top = stack.pop();

                        if (ch == ')' && top != '(' || ch == '}' && top != '{' || ch == ']' && top != '[') {
                            System.out.printf("Error: mismatched symbols %c and %c at line %d\n", top, ch, lineNumber);
                            return;
                        }
                    }
                }

                lineNumber++;
            }

            if (!stack.isEmpty()) {
                char top = stack.pop();
                System.out.printf("Error: no closing symbol for %c\n", top);
            } else {
                System.out.println("All grouping symbols are matched");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
