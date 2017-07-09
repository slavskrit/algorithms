public class Solution {
    
    public int calculate(String s) {
        int result = 0;
        char[] array = s.toCharArray();
        char lastOperator = ' ';
        int length = array.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= length; i++) {
            if (i == length || array[i] =='-' || array[i] =='+' || array[i] =='*' || array[i] =='/') {
                deque.push(result);
                if (lastOperator != ' ') {
                    if (lastOperator == '*') {
                        deque.push(deque.pop() * deque.poll());
                    } else if (lastOperator == '/') {
                        int a = deque.pop();
                        int b = deque.pop();
                        deque.push( b / a);
                    } else if (lastOperator == '-') {
                        deque.push(deque.poll() * -1);
                    }
                }
                result = 0;
                if (i != length) lastOperator = array[i];
            } else {
                if (Character.isDigit(array[i])) result = result * 10 + array[i] - '0';
            }
        }
        while (!deque.isEmpty()) {
            result += deque.pop();
        }
        return result;
    }
}
