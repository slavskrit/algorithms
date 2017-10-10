// https://leetcode.com/problems/longest-valid-parentheses
// 
// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
// 
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
// 
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
class Solution {
    public int longestValidParentheses(String s) {
        int helper = 0, result = 0;
        char[] array = s.toCharArray();
        int[] dp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '(') {
                helper++;
            } else {
                if (helper != 0) {
                  helper--;
                  int value = Math.max(dp[i - 1], i > 2 ? dp[i - 2] : 0) + 2;
                  value += i >= value ? dp[i - value] : 0;
                  result = Math.max(result, value);
                  dp[i] = value;
                }
            }
        }
        return result;
    }
}
