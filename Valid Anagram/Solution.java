// https://leetcode.com/problems/valid-anagram
// 
// Given two strings s and t, write a function to determine if t is an anagram of s.
// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.
// 
// Note:
// You may assume the string contains only lowercase alphabets.
// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int a[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++; 
        }
        for(int i = 0; i < s.length(); i++) {
            a[t.charAt(i) - 'a']--;
        }
        for(int i: a) {
            if (i != 0) return false; 
        }
        return true;
    }
}
