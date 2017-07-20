public class Solution {
    public int minPathSum(int[][] grid) {
        int y = grid.length;
        int x = grid[0].length;
        if (y == 0) return 0;
        int[] dp = new int[x];
        dp[0] = grid[0][0];
        for (int i = 1; i < x; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }
        for (int i = 1; i < y; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < x; j++) {
                dp[j] = Math.min(dp[j - 1] + grid[i][j], dp[j] + grid[i][j]);
            }
        }
        return dp[x - 1];
    }
}
