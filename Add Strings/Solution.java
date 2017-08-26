// https://leetcode.com/problems/add-strings
// 
// Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
// Note:
// 
// The length of both num1 and num2 is < 5100.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.
// 
// 
public class Solution {
    public String addStrings(String num1, String num2) {
        String greater = num1.length() > num2.length() ? num1 : num2;
        String smaller = greater == num1 ? num2 : num1;
        char[] result = new char[greater.length() + 1];
        int s = smaller.length() - 1;
        boolean overflow = false;
        int carry = result.length - 1;
        for (int i = greater.length() - 1; i >= 0; i--) {
            int t = 0;
            if (s >= 0) {
                t = greater.charAt(i) + smaller.charAt(s) - '0' - '0';
                s--;
            } else {
                t = greater.charAt(i) - '0';
            }
            if (overflow) {
                t++;
                overflow = false;
            }
            if (t > 9) {
                overflow = true;
            }
            result[carry] = (char) ((t % 10) + '0');
            carry--;
        }
        if (overflow){
            result[0] = '1';
            return new String(result);
        } else {
            return new String(result, 1, result.length - 1);
        }
    }
}
