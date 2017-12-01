// https://leetcode.com/problems/maximum-product-of-word-lengths
// 
// Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
// 
// Example 1:
// Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
// Return 16
// The two words can be "abcw", "xtfn".
// 
// Example 2:
// Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
// Return 4
// The two words can be "ab", "cd".
// 
// Example 3:
// Given ["a", "aa", "aaa", "aaaa"]
// Return 0
// No such pair of words.
// 
// Credits:
// Special thanks to @dietpepsi for adding this problem and creating all test cases.
class Solution {
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] buckets = new int[length];
        for (int i = 0; i < length; i++) {
            buckets[i] = getValue(words[i]);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((buckets[i] & buckets[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    private int getValue(String word) {
        boolean[] temp = new boolean[26];
        for (char c : word.toCharArray()) temp[c - 'a'] = true;
        int hash = 0;
        for (int i = 0; i < 26; i++) {
            hash += !temp[i] ? 0 : 2 << i;
        }
        return hash;
    }
}
