// https://leetcode.com/problems/perfect-squares
//
// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
// 
// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
// 
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int localMin;
        for (int i = 2; i <= n; i++) {
            localMin = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                localMin = Math.min(localMin, dp[i - j * j]);
            }
            dp[i] = localMin + 1;
        }
        return dp[n];
    }
}
