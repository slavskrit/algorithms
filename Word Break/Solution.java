// https://leetcode.com/problems/word-break
// 
// 
// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
// 
// For example, given
// s = "leetcode",
// dict = ["leet", "code"].
// 
// 
// Return true because "leetcode" can be segmented as "leet code".
// 
// 
// UPDATE (2017/1/4):
// The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
// 
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        if (length == 0) return true;
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (wordDict.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[length];
    }
}
