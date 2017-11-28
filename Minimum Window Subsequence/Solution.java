// https://leetcode.com/problems/minimum-window-subsequence
// 
// Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
// 
// If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
// 
// Example 1:
// Input: 
// S = "abcdebdde", T = "bde"
// Output: "bcde"
// Explanation: 
// "bcde" is the answer because it occurs before "bdde" which has the same length.
// "deb" is not a smaller window because the elements of T in the window must occur in order.
// Note:
// 
// All the strings in the input will only contain lowercase letters.
// The length of S will be in the range [1, 20000].
// The length of T will be in the range [1, 100].
class Solution {
    public String minWindow(String S, String T) {
        char[] first = S.toCharArray();
        char[] second = T.toCharArray();
        int firstLength = first.length;
        int secondLength = second.length;
        int[][] dp = new int[firstLength][secondLength];
        if (second.length == 1) {
            int p = S.indexOf(T);
            return p == -1 ? "" : T;
        }
        if (first[0] == second[0]) dp[0][0] = 1;
        String result = S;
        for (int i = 1; i < firstLength; i++) {
            if (first[i] == second[0]) dp[i][0] = i;
            else dp[i][0] = dp[i - 1][0];
            for (int j = 1; j < secondLength; j++) {
                if (first[i] == second[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (j == secondLength - 1 && dp[i][j] != 0 && result.length() > i + 1 - dp[i][j]) {
                    int start = dp[i][j];
                    if (start == 1) {
                        start = first[0] == second[0] ? 0 : 1;
                    }
                    result = S.substring(start, i + 1);
                }
            }
        }
        return result.equals(S) ? "" : result;
    }
}
