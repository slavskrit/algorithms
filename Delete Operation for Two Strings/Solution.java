// https://leetcode.com/problems/delete-operation-for-two-strings
// 
// 
// Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
// 
// Example 1:
// 
// Input: "sea", "eat"
// Output: 2
// Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
// 
// 
// Note:
// 
// The length of given words won't exceed 500.
// Characters in given words can only be lower-case letters.
// 
// 
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
