// https://leetcode.com/problems/basic-calculator-ii
// 
// Implement a basic calculator to evaluate a simple expression string.
// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces  . The integer division should truncate toward zero.
// You may assume that the given expression is always valid.
// Some examples:
// 
// "3+2*2" = 7
// " 3/2 " = 1
// " 3+5 / 2 " = 5
// 
// 
// 
// Note: Do not use the eval built-in library function.
// 
// Credits:Special thanks to @ts for adding this problem and creating all test cases.
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
