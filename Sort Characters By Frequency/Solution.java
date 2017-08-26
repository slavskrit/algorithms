// https://leetcode.com/problems/sort-characters-by-frequency
// 
// Given a string, sort it in decreasing order based on the frequency of characters.
// Example 1:
// 
// Input:
// "tree"
// 
// Output:
// "eert"
// 
// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// 
// 
// Example 2:
// 
// Input:
// "cccaaa"
// 
// Output:
// "cccaaa"
// 
// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
// 
// 
// Example 3:
// 
// Input:
// "Aabb"
// 
// Output:
// "bbAa"
// 
// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
// 
// 
public class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        while (sb.length() != s.length()) {
            int max = 0;
            char c = ' ';
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] > max) {
                    max = hash[i];
                    c = (char) i;
                }
            }
            hash[c] = 0;
            while (--max > -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
