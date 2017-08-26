// https://leetcode.com/problems/evaluate-reverse-polish-notation
// 
// 
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// 
// 
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
// 
// 
// Some examples:
// 
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
// 
// 
public class Solution {

     static boolean isValidOperator(String operator) {
        return operator.equals("+") ||
                operator.equals("-") ||
                operator.equals("/") ||
                operator.equals("*");
    }

    static int perform(int a, int b, char operator) {
        switch (operator) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            default: return a / b;
        } 
    }

    public int evalRPN(String[] tokens) {
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (String token: tokens) {
            if (isValidOperator(token)) {
                int b = stack.poll();
                int a = stack.poll();
                char op = token.charAt(0);
                result = perform(a, b, op);
                stack.push(result);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
