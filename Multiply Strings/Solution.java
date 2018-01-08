// https://leetcode.com/problems/multiply-strings
//
// Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
//
// Note:
//
// The length of both num1 and num2 is < 110.
// Both num1 and num2 contains only digits 0-9.
// Both num1 and num2 does not contain any leading zero.
// You must not use any built-in BigInteger library or convert the inputs to integer directly.
class Solution {
    public String multiply(String num1, String num2) {
        char[] first = num1.toCharArray();
        char[] second = num2.toCharArray();
        int firstLength = first.length;
        int secondLength = second.length;
        int resultLength = firstLength + secondLength;
        char[] result = new char[resultLength];
        int multiply = 0, cursor = 0;
        for (int s = secondLength - 1; s >= 0; s--) {
            for (int f = firstLength - 1; f >= 0; f--) {
                multiply = (second[s] - '0') * (first[f] - '0');
                cursor = s + f + 1;
                multiply += result[cursor];
                result[cursor] = 0;
                result[cursor - 1] += multiply / 10;
                result[cursor] += multiply % 10;
            }
        }
        cursor = 0;
        if (result[0] == 0) {
            if (result[1] == 0) return "0";
            cursor = 1;
        }
        for (int i = 0; i < resultLength; i++) result[i] += '0';
        return new String(result, cursor, resultLength - cursor);
    }
}
