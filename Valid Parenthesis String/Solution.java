// https://leetcode.com/problems/valid-parenthesis-string
// 
// Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
// 
// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
// An empty string is also valid.
// Example 1:
// Input: "()"
// Output: True
// Example 2:
// Input: "(*)"
// Output: True
// Example 3:
// Input: "(*))"
// Output: True
// Note:
// The string size will be in the range [1, 100].
class Solution {
    public boolean checkValidString(String s) {
        int open = 0;
        int mimic = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                mimic++;
            } else if (c == ')') {
                open--;
                mimic--;
            } else {
                open--;
                mimic++;
            }
            open = Math.max(open, 0);
            if (mimic < 0) return false;
        }
        return open == 0;
    }
}
