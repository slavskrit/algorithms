// https://leetcode.com/problems/sum-of-square-numbers
// 
// 
// Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
// 
// Example 1:
// 
// Input: 5
// Output: True
// Explanation: 1 * 1 + 2 * 2 = 5
// 
// 
// Example 2:
// 
// Input: 3
// Output: False
// 
// 
// 
public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 3) return true;
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int mid = left * left + right * right;
            if (mid < c) {
                left++;
            } else if (mid > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
