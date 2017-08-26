// https://leetcode.com/problems/isomorphic-strings
// 
// Given two strings s and t, determine if they are isomorphic.
// Two strings are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
// For example,
// Given "egg", "add", return true.
// Given "foo", "bar", return false.
// Given "paper", "title", return true.
// Note:
// You may assume both s and t have the same length.
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] firstBucket = new int[256];
        int[] secondBucket = new int[256];
        int[] firstHelper = new int[s.length()];
        int[] secondHelper = new int[s.length()];
        for (int i = 0, firstCursor = 0, secondCursor = 0; i < s.length(); i++) {
            if (firstBucket[s.charAt(i)] == 0) firstBucket[s.charAt(i)] = firstCursor++;
            if (secondBucket[t.charAt(i)] == 0) secondBucket[t.charAt(i)] = secondCursor++;
        }
        for (int i = 0; i < s.length(); i++) {
            firstHelper[i] = firstBucket[s.charAt(i)];
            secondHelper[i] = secondBucket[t.charAt(i)];
        }
        for (int i = 0; i < firstHelper.length; i++) {
            if (firstHelper[i] != secondHelper[i]) return false;
        }
        return true;
    }
}
