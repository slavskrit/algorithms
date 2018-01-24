// https://leetcode.com/problems/sentence-similarity-ii
// 
// Given two sentences words1, words2 (each represented as an array of strings), and a list of similar word pairs pairs, determine if two sentences are similar.
// 
// For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], ["acting","drama"], ["skills","talent"]].
// 
// Note that the similarity relation is transitive. For example, if "great" and "good" are similar, and "fine" and "good" are similar, then "great" and "fine" are similar.
// 
// Similarity is also symmetric. For example, "great" and "fine" being similar is the same as "fine" and "great" being similar.
// 
// Also, a word is always similar with itself. For example, the sentences words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.
// 
// Finally, sentences can only be similar if they have the same number of words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].
// 
// Note:
// 
// The length of words1 and words2 will not exceed 1000.
// The length of pairs will not exceed 2000.
// The length of each pairs[i] will be 2.
// The length of each words[i] and pairs[i][j] will be in the range [1, 20].
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] pair : pairs) {
            Set<String> set = map.getOrDefault(pair[0], new HashSet<>());
            set.add(pair[1]);
            map.put(pair[0], set);
            set = map.getOrDefault(pair[1], new HashSet<>());
            set.add(pair[0]);
            map.put(pair[1], set);
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                if (!isTransitive(words1[i], words2[i], map)) return false;
            }
        }
        return true;
    }

    private boolean isTransitive(String start, String end, Map<String, Set<String>> map) {
        if (start.equals(end)) return true;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            visited.add(current);
            Set<String> set = map.get(current);
            if (set == null) continue;
            if (set.contains(end)) return true;
            for (String word : set) {
                if (!visited.contains(word)) {
                    queue.offer(word);
                }
            }
        }
        return false;
    }
}
