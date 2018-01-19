// https://leetcode.com/problems/add-bold-tag-in-string
// 
// Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
// Example 1:
// Input: 
// s = "abcxyz123"
// dict = ["abc","123"]
// Output:
// "<b>abc</b>xyz<b>123</b>"
// Example 2:
// Input: 
// s = "aaabbcc"
// dict = ["aaa","aab","bc"]
// Output:
// "<b>aaabbc</b>c"
// Note:
// The given dict won't contain duplicates, and its length won't exceed 100.
// All the strings in input have length in range [1, 1000].
class Solution {
    public String addBoldTag(String s, String[] dict) {
        String open = "<b>";
        String close = "</b>";
        StringBuilder sb = new StringBuilder();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (String word : dict) {
            int index = s.indexOf(word);
            int length = word.length();
            while (index != -1) {
                map.put(index, Math.max(map.getOrDefault(index, 0), index + length));
                index = s.indexOf(word, index + 1);
            }
        }
        if (map.isEmpty()) return s;
        Deque<int[]> indexes = new ArrayDeque<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (indexes.isEmpty() || indexes.peek()[1] < entry.getKey())
                indexes.push(new int[]{entry.getKey(), entry.getValue()});
            else if (!indexes.isEmpty()
                    && entry.getKey() <= indexes.peek()[1]
                    && indexes.peek()[1] <= entry.getValue()) {
                indexes.peek()[1] = entry.getValue();
            }
        }
        int start = indexes.peekLast()[0];
        int end = indexes.peekLast()[1];
        indexes.pollLast();
        for (int i = 0; i < s.length(); i++) {
            if (i == start) {
                sb.append(open);
            } else if (i == end) {
                sb.append(close);
                if (!indexes.isEmpty()) {
                    start = indexes.peekLast()[0];
                    end = indexes.peekLast()[1];
                    indexes.pollLast();
                }
            }
            sb.append(s.charAt(i));
        }
        if (end == s.length()) sb.append(close);
        return sb.toString();
    }
}
