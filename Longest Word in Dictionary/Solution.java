// https://leetcode.com/problems/longest-word-in-dictionary
// 
// Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
// 
// If there is no answer, return the empty string.
// Example 1:
// Input: 
// words = ["w","wo","wor","worl", "world"]
// Output: "world"
// Explanation: 
// The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
// Example 2:
// Input: 
// words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
// Output: "apple"
// Explanation: 
// Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
// Note:
// 
// All the strings in the input will only contain lowercase letters.
// The length of words will be in the range [1, 1000].
// The length of words[i] will be in the range [1, 30].
class Solution {
    public String longestWord(String[] words) {
        if (words.length == 0) return "";
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String result = words[0];
        for (String word : words) {
            if (word.isEmpty()) continue;
            if (word.length() == 1) {
                set.add(word);
            } else {
                if (set.contains(word.substring(0, word.length() - 1))) {
                    if (result.length() <= word.length()) {
                        if (result.length() == word.length()) {
                            result = result.compareTo(word) < 0 ? result : word;
                        } else {
                            result = word;
                        }
                    }
                    set.add(word);
                }
            }
        }
        return result;
    }
}
