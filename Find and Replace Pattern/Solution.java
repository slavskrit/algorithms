// https://leetcode.com/problems/find-and-replace-pattern/description/
// 
// You have a list of words and a pattern, and you want to know which words in words matches the pattern.
// 
// A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
// 
// (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
// 
// Return a list of the words in words that match the given pattern. 
// 
// You may return the answer in any order.
// 
//  
// 
// Example 1:
// 
// Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
// Output: ["mee","aqq"]
// Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
// "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
// since a and b map to the same letter.
//  
// 
// Note:
// 
// 1 <= words.length <= 50
// 1 <= pattern.length = words[i].length <= 20
class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        int hash = getHash(getPattern(pattern));
        for (String word : words) {
            if (getHash(getPattern(word)) == hash) {
                result.add(word);
            }
        }
        return result;
    }

    private int getHash(int[] pattern) {
        int hash = 0;
        for (int i : pattern) {
            hash = hash * 31 + i;
        }
        return hash;
    }

    private int[] getPattern(String word) {
        Map<Character, Integer> map = new HashMap<>();
        int[] pattern = new int[word.length()];
        int uniques = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i + uniques++);
            }
            pattern[i] = map.get(c);
        }
        return pattern;
    }
}
