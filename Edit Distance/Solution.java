// https://leetcode.com/problems/edit-distance
// 
// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
// 
// You have the following 3 operations permitted on a word:
// 
// a) Insert a character
// b) Delete a character
// c) Replace a character
class Solution {
    public int minDistance(String word1, String word2) {
        int first_length = word1.length();
        int second_length = word2.length();
        if (first_length == 0 || second_length == 0) {
            return Math.abs(first_length - second_length);
        }
        char[] first = word1.toCharArray();
        char[] second = word2.toCharArray();
        int[][] dp = new int[first_length + 1][second_length + 1];
        for (int i = 1; i <= first_length; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= second_length; j++) {
                dp[0][j] = j;
                if (first[i - 1] == second[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = dp[i - 1][j];
                    int remove = dp[i][j - 1];
                    int replace = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(Math.min(insert, remove), replace) + 1;
                }
            }
        }
        return dp[first_length][second_length];
    }
}
