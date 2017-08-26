// https://leetcode.com/problems/solve-the-equation
// 
// 
// Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.
// 
// 
// If there is no solution for the equation, return "No solution".
// 
// 
// If there are infinite solutions for the equation, return "Infinite solutions".
// 
// 
// If there is exactly one solution for the equation, we ensure that the value of x is an integer.
// 
// Example 1:
// 
// Input: "x+5-3+x=6+x-2"
// Output: "x=2"
// 
// 
// Example 2:
// 
// Input: "x=x"
// Output: "Infinite solutions"
// 
// 
// Example 3:
// 
// Input: "2x=x"
// Output: "x=0"
// 
// 
// Example 4:
// 
// Input: "2x+3x-6x=x+2"
// Output: "x=-1"
// 
// 
// Example 5:
// 
// Input: "x=x+2"
// Output: "No solution"
// 
// 
public class Solution {
    
    int begin = 0;

    public String solveEquation(String equation) {
        char[] array = equation.toCharArray();
        int[] leftValues = evaluate(array, begin, equation.length());
        int[] rightValues = evaluate(array, begin, equation.length());
        int x = leftValues[0] - rightValues[0];
        int digits = rightValues[1] - leftValues[1];
        if (x == 0 && digits == 0) return "Infinite solutions";
        if (x == 0) return "No solution";
        return "x=" + digits / x;
    }

    private int[] evaluate(char[] array, int start, int end) {
        int temp = 0, x = 0, digit = 0;
        boolean ifPositive = true;
        boolean ifStartWithZero = false;
        while (start < end) {
            char current = array[start];
            if (Character.isDigit(current)) {
                temp = temp * 10 + (current - '0');
                if (temp == 0) {
                    ifStartWithZero = true;
                }
            } else {
                if (current == 'x') {
                    if (temp == 0) {
                        temp = 1;
                        if (ifStartWithZero) {
                            temp = 0;
                            ifStartWithZero = false;
                        }
                    }
                    if (!ifPositive) {
                        temp = -temp;
                        ifPositive = true;
                    }
                    x += temp;
                } else {
                    if (!ifPositive) {
                        temp = -temp;
                        ifPositive = true;
                    }
                    digit += temp;
                }
                temp = 0;
                if (current == '-') {
                    ifPositive = false;
                }
            }
            start++;
            if (current == '=') {
                break;
            }
        }
        digit += ifPositive ? temp : -temp;
        begin = start;
        return new int[]{x, digit};
    }
}
