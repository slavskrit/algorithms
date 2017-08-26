// https://leetcode.com/problems/factorial-trailing-zeroes
// 
// Given an integer n, return the number of trailing zeroes in n!.
// Note: Your solution should be in logarithmic time complexity.
// Credits:Special thanks to @ts for adding this problem and creating all test cases.
public class Solution {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
