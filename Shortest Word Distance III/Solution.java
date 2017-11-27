// https://leetcode.com/problems/shortest-word-distance-iii
// 
// This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
// 
// Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
// 
// word1 and word2 may be the same and they represent two individual words in the list.
// 
// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
// 
// Given word1 = “makes”, word2 = “coding”, return 1.
// Given word1 = "makes", word2 = "makes", return 3.
// 
// Note:
// You may assume word1 and word2 are both in the list.
class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> positions = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> temp = positions.getOrDefault(words[i], new ArrayList<>());
            temp.add(i);
            positions.put(words[i], temp);
        }
        if (word1.equals(word2)) {
            List<Integer> temp = positions.get(word1);
            if (temp.size() == 1) return 0;
            int result = Integer.MAX_VALUE;
            for (int i = 1; i < temp.size(); i++) {
                result = Math.min(result, temp.get(i) - temp.get(i - 1));
            }
            return result;
        }
        List<Integer> first = positions.get(word1);
        List<Integer> second = positions.get(word2);
        int result = Integer.MAX_VALUE;
        for (Integer f : first) {
            for (Integer s : second) {
                result = Math.min(result, Math.abs(s - f));
            }
        }
        return result;
    }
}
