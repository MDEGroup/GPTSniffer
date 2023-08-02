import java.util.*;public class InfixToPostfix {  public static String infixToPostfix(String expression) {    StringBuilder postfix = new StringBuilder();    Stack<Character> stack = new Stack<>();    for (int i = 0; i < expression.length(); i++) {      char ch = expression.charAt(i);      if (Character.isDigit(ch)) {        postfix.append(ch);      } else if (ch == '(') {        stack.push(ch);      } else if (ch == ')') {        while (!stack.isEmpty() && stack.peek() != '(') {          postfix.append(stack.pop());        }        stack.pop(); 