package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;


// 참고 https://en.wikipedia.org/wiki/Reverse_Polish_notation
public class ReversePolishNotation {

    public int calc(int a, int b, String op) {
        if (op.equals("+")) {
            return a + b;
        }
        if (op.equals("-")) {
            return a - b;
        }
        if (op.equals("/")) {
            return a / b;
        }
        if (op.equals("*")) {
            return a * b;
        }
        return 0;
    }

    public int process(int index, Stack<String> stack, String[] tokens) {
        System.out.println("present stack : " + stack);
        List<String> ops = Arrays.asList("+", "-", "/", "*");
        if (index == tokens.length) {
            return Integer.parseInt(stack.pop());
        }

        int nextIndex = 0;
        for (int i = index; i < tokens.length; i++) {
            if (ops.contains(tokens[i])) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int c = calc(b, a, tokens[i]);
                System.out.printf("%d %s %d => %d\n", a, tokens[i], b, c);
                stack.push(String.valueOf(c));
                nextIndex = i+1;
                break;
            }
            stack.push(tokens[i]);
        }
        return process(nextIndex, stack, tokens);
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        return process(0, stack, tokens);
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        ReversePolishNotation reversePolishNotation = new ReversePolishNotation();
        int answer = reversePolishNotation.evalRPN(tokens);
        System.out.println("answer : " + answer); // 22
    }
}
