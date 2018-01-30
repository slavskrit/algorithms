// https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters
// 
// Given a string, find the length of the longest substring T that contains at most 2 distinct characters.
// 
// For example, Given s = “eceba”,
// 
// T is "ece" which its length is 3.
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int result = 0;
        int[] bucket = new int[256];
        int first = 0;
        int second = 0;
        char[] a = s.toCharArray();
        int distincts = 0;
        while (second <= s.length()) {
            while (distincts > 2) {
                if (bucket[a[first]] == 1) {
                    distincts--;
                }
                bucket[a[first]]--;
                first++;
            }
            result = Math.max(result, second - first);
            if (second == s.length()) break;
            if (bucket[a[second]]++ == 0) {
                distincts++;
            }
            second++;

        }
        return Math.max(result, distincts);
    }
}
