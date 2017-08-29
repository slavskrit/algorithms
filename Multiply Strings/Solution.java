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
        int[] result = new int[firstLength + secondLength];
        for (int s = secondLength - 1; s >= 0; s--) {
            for (int f = firstLength - 1; f >= 0; f--) {
                int multiply = (second[s] - '0') * (first[f] - '0');
                int left = s + f;
                int right = s + f + 1;
                int sum = multiply;
                sum += result[right];
                result[left] += sum / 10;
                result[right] = sum % 10;
            }
        }
        int pointer = -1;
        while (++pointer < result.length && result[pointer] == 0);
        int begin = pointer;
        char[] string = new char[result.length - begin];
        pointer = 0;
        if (string.length == 0) return "0";
        while (pointer < string.length) {
            string[pointer] = (char) (result[pointer + begin] + '0');
            pointer++;
        }
        return new String(string);
    }
}
