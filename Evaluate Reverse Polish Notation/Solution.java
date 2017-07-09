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
