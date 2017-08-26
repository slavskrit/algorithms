// https://leetcode.com/problems/repeated-substring-pattern
// 
// Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.  You may assume the given string consists of lowercase English letters only and its length  will not exceed 10000. 
// 
// Example 1:
// 
// Input: "abab"
// 
// Output: True
// 
// Explanation: It's the substring "ab" twice.
// 
// 
// Example 2:
// 
// Input: "aba"
// 
// Output: False
// 
// 
// Example 3:
// 
// Input: "abcabcabcabc"
// 
// Output: True
// 
// Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
// 
// 
public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        char start = str.charAt(0);
        char end = str.charAt(str.length() - 1);
        List<Integer> indexes = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == start && str.charAt(i - 1) == end) {
                indexes.add(i);
            }
        }
        for (int index = 0; index < indexes.size(); index++) {
            for (int i = 0, helper = 0; i <= str.length(); i++) {
                if (i == str.length() && helper == 0) return true;
                if (i == str.length() && helper != 0) return false;
                if (str.charAt(i) == str.charAt(helper)) {
                    helper++;
                    if (helper == indexes.get(index)) helper = 0;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
