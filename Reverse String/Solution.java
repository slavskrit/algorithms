// https://leetcode.com/problems/reverse-string
// 
// Write a function that takes a string as input and returns the string reversed.
// 
// Example:
// Given s = "hello", return "olleh".
public class Solution {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return new String(chars);
    }
}
