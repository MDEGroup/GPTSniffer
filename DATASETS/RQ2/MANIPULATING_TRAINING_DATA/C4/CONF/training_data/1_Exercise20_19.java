

import java.util.Stack;


public class Exercise20_19 {
    static final String[] operators = new String[]{"+", "-", "*", "/"};

    public static void main(String[] args) {
        
        long totalPossibleCombinations = findTotalPossibleCombinations(4, 52);
        System.out.println("Number of possible picks of four cards from 52 card deck? Answer: ");
        System.out.println(totalPossibleCombinations);
        
        long numPicksWith24PtTotal = findCombinationsWithTarget(24);
        System.out.println("Out of all possible picks of 4 how many have 24 pt solution? Answer: ");
        System.out.println(numPicksWith24PtTotal);
        
        System.out.println("What is the success ratio (number of picks with solutions)/(number of all possible picks of four cards)? Answer:");
        System.out.println((double) numPicksWith24PtTotal / totalPossibleCombinations);

    }

    
    static long findTotalPossibleCombinations(int r, int n) {
        
        long permutations = 1; 
        long slots = 1; 
        int sampleFactor = n;
        int slotsFactor = r;

        while (slotsFactor >= 1) {
            permutations *= sampleFactor;
            slots *= slotsFactor;
            sampleFactor--;
            slotsFactor--;
        }

        return permutations / slots;
    }

    
    static long findCombinationsWithTarget(int target) {
        int c = 0;
        int[] hearts = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] clubs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] spades = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[] diamonds = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int c1, c2, c3, c4 = 0;
        for (int h = 0; h < hearts.length; h++) {
            c1 = hearts[h];
            for (int cl = 0; cl < clubs.length; cl++) {
                c2 = clubs[cl];
                for (int s = 0; s < spades.length; s++) {
                    c3 = spades[s];
                    for (int d = 0; d < diamonds.length; d++) {
                        c4 = diamonds[d];
                        for (int o1 = 0; o1 < operators.length; o1++) {
                            String op1 = operators[o1];
                            for (int o2 = 0; o2 < operators.length; o2++) {
                                String op2 = operators[o2];
                                for (int o3 = 0; o3 < operators.length; o3++) {
                                    String op3 = operators[o3];
                                    String exp = c1 + op1 + c2 + op2 + c3 + op3 + c4;
                                    if (evalExpression(exp) == target) {
                                        c++;
                                    }
                                }
                            }


                        }

                    }
                }
            }
        }
        return c;
    }


    private static int evalExpression(String exp) {
        
        Stack<Integer> operandStack = new Stack<>();

        
        Stack<Character> operatorStack = new Stack<>();

        
        exp = delimit(exp);

        String[] tokens = exp.split(" ");

        for (String token : tokens) {
            if (token.length() == 0) { 
                continue;
            } else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-'
                        || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));

            } else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token.charAt(0));

            } else if (token.trim().charAt(0) == '(') {
                operatorStack.push('('); 
            } else if (token.trim().charAt(0) == ')') {
                
                while (operatorStack.peek() != '(') {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.pop(); 
            } else { 
                
                operandStack.push(new Integer(token));
            }
        }
        
        while (!operatorStack.isEmpty()) {
            processOperator(operandStack, operatorStack);
        }
        
        return operandStack.pop();
    }

    
    private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
        char op = operatorStack.pop();
        int op1 = operandStack.pop();
        int op2 = operandStack.pop();
        if (op == '+')
            operandStack.push(op2 + op1);
        else if (op == '-')
            operandStack.push(op2 - op1);
        else if (op == '*')
            operandStack.push(op2 * op1);
        else if (op == '/')
            operandStack.push(op2 / op1);
    }

    private static String delimit(String str) {
        String res = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == ')' || str.charAt(i) == '+' || str.charAt(i) == '-'
                    || str.charAt(i) == '/' || str.charAt(i) == '*') {

                res += " " + str.charAt(i) + " ";

            } else {
                res += str.charAt(i);

            }

        }

        return res;
    }
}
