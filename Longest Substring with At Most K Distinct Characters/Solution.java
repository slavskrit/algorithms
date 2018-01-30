// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
// 
// Given a string, find the length of the longest substring T that contains at most k distinct characters.
// 
// For example, Given s = “eceba” and k = 2,
// 
// T is "ece" which its length is 3.
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        int first = 0;
        int second = 0;
        char[] a = s.toCharArray();
        while (second <= s.length()) {
            while (map.size() > k) {
                if (map.get(a[first]) == 1) {
                    map.remove(a[first]);
                } else {
                    map.put(a[first], map.get(a[first]) - 1);
                }
                first++;
            }
            result = Math.max(result, second - first);
            if (second == s.length()) break;
            map.put(a[second], map.getOrDefault(a[second], 0) + 1);
            second++;

        }
        return Math.max(result, 0);
    }
}
