// https://leetcode.com/problems/longest-substring-without-repeating-characters
// 
// Given a string, find the length of the longest substring without repeating characters.
// Examples:
// Given "abcabcbb", the answer is "abc", which the length is 3.
// Given "bbbbb", the answer is "b", with the length of 1.
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int result = 0;
        int temp = 0;
        int[] bucket = new int[256];
        for (int i = 0, k = 0; k < s.length();) {
            if (bucket[s.charAt(k)] == 0) {
                bucket[s.charAt(k)]++;
                k++;
                temp++;
                result = Math.max(result, temp);
            } else {
                bucket[s.charAt(i)]--;
                temp--;
                i++;
            }
        }
        return result;
    }
}
