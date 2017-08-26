// https://leetcode.com/problems/substring-with-concatenation-of-all-words
// 
// 
// You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
// 
// 
// For example, given:
// s: "barfoothefoobarman"
// words: ["foo", "bar"]
// 
// 
// You should return the indices: [0,9].
// (order does not matter).
// 
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> firstMap = new HashMap<>();
        for (String word : words) {
            Integer a = firstMap.get(word);
            if (a == null) firstMap.put(word, 1);
            else firstMap.put(word, a + 1);
        }
        int len = words[0].length();
        for (int start = 0, end = words.length * len; end <= s.length(); start++, end++) {
            if (contains(s.substring(start, end), firstMap, len)) {
                result.add(start);
            }
        }
        return result;
    }

    private boolean contains(String a, HashMap<String, Integer> firstMap, int len) {
        HashMap<String, Integer> map = new HashMap<>(firstMap);
        for (int start = 0, end = len; end <= a.length(); start += len, end += len) {
            String t = a.substring(start, end);
            Integer i = map.get(t);
            if (i == null || i <= 0) {
                return false;
            } else {
                map.put(t, i - 1);
            }
        }
        return true;
    }
}
