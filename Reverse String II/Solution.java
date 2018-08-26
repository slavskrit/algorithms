// https://leetcode.com/problems/reverse-string-ii/description/
// 
// Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
// Example:
// Input: s = "abcdefg", k = 2
// Output: "bacdfeg"
// Restrictions:
// The string consists of lower English letters only.
// Length of the given string and k will in the range [1, 10000]
class Solution {
    public String reverseStr(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i += k * 2) {
            reverse(c, i, Math.min(i + k - 1, c.length - 1));
        }
        return new String(c);
    }

    private void reverse(char[] c, int left, int right) {
        while (left < right) {
            char t = c[left];
            c[left++] = c[right];
            c[right--] = t;
        }
    }
}
