public class Solution {
    public int minDistance(String word1, String word2) {
        int w1l = word1.length();
        int w2l = word2.length();
        if (w1l == 0) return w2l;
        if (w2l == 0) return w1l;
        int dp[][] = new int[w1l + 1][w2l + 1];
        for (int i = 1; i <= w1l; i++) {
            for (int j = 1; j <= w2l; j++) {
                dp[i][j] = (word1.charAt(i-1) == word2.charAt(j-1)) ? dp[i-1][j-1] + 1
                        : Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return w1l + w2l - dp[w1l][w2l] * 2;
    }
}
