// https://leetcode.com/problems/ransom-note
// 
// 
// Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom 
// note can be constructed from the magazines ; otherwise, it will return false. 
// 
// 
// Each letter in the magazine string can only be used once in your ransom note.
// 
// Note:
// You may assume that both strings contain only lowercase letters.
// 
// 
// canConstruct("a", "b") -> false
// canConstruct("aa", "ab") -> false
// canConstruct("aa", "aab") -> true
// 
// 
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int chars[] = new int[26];
        char r[] = ransomNote.toCharArray();
        char m[] = magazine.toCharArray();
        for (int i = 0; i < r.length; i++) {
            chars[r[i] - 'a']++;
        }
        for (int i = 0; i < m.length; i++) {
            chars[m[i] - 'a']--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
