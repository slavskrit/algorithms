public class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        if (length == 0) return 0;
        int[][] dp = new int[length][length];
        int temp = 0;
        for (int i = length - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (array[i] == array[j]) {
                    temp = dp[i + 1][j - 1] + 2;
                } else {
                    temp = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                dp[i][j] = temp;
            }
        }
        return dp[0][length - 1];
    }
}
