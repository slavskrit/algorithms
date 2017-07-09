public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] dp = new int[height][width];
        dp[height - 1][width - 1] = Math.max(1 - dungeon[height - 1][width - 1], 1);
        for (int i = width - 2; i >= 0; i--) {
            dp[height - 1][i] = Math.max(dp[height - 1][i + 1] - dungeon[height - 1][i], 1);
        }
        for (int j = height - 2; j >= 0; j--) {
            dp[j][width - 1] = Math.max(dp[j + 1][width - 1] - dungeon[j][width - 1], 1);
        }
        for (int i = height - 2; i >= 0; i--) {
            for (int j = width - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }
}
