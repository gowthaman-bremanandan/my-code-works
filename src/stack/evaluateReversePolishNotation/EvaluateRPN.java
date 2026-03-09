package stack.evaluateReversePolishNotation;

import java.util.Stack;

public class EvaluateRPN {

    public static void main(String[] args) {

        EvaluateRPN solver = new EvaluateRPN();

        System.out.println("Example 1:");
        System.out.println(
                solver.evalRPN(
                        new String[]{"1","2","+","3","*","4","-"}
                )
        ); // 5
    }

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (isOperator(token)) {

                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand

                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b; // truncates toward zero
                        break;
                }

                stack.push(result);

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/");
    }
}