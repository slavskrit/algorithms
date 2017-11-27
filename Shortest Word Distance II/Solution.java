// https://leetcode.com/problems/shortest-word-distance-ii
// 
// This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
// 
// Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
// 
// For example,
// Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
// 
// Given word1 = “coding”, word2 = “practice”, return 3.
// Given word1 = "makes", word2 = "coding", return 1.
// 
// Note:
// You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
class WordDistance {

    private final Map<String, List<Integer>> positions;

    public WordDistance(String[] words) {
        positions = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> temp = positions.getOrDefault(words[i], new ArrayList<>());
            temp.add(i);
            positions.put(words[i], temp);
        }
    }

    public int shortest(String word1, String word2) {
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

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
