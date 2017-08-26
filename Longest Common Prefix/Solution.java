// https://leetcode.com/problems/longest-common-prefix
// 
// Write a function to find the longest common prefix string amongst an array of strings.
// 
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String result = strs[0];
        int current = 1;
        while (current < strs.length) {
            while (strs[current].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
            current++;
        }
        return result;
    }
}
