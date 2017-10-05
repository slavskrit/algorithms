// https://leetcode.com/problems/minimum-path-sum
// 
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
// Note: You can only move either down or right at any point in time.
public class Solution {
    public int minPathSum(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;
        if (x == 0) return 0;
        int[] dp = new int[x];
        for (int i = 0; i < y; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < x; j++) {
                if (i == 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } else {
                    dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
                }
            }
        }
        return dp[x - 1];
    }
}
