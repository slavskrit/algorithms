public class Solution {
    public String solveEquation(String equation) {
        char[] array = equation.toCharArray();
        int[] leftValues = evaluate(array, 0, equation.length());
        int[] rightValues = evaluate(array, leftValues[2], equation.length());
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
        return new int[]{x, digit, start};
    }
}
