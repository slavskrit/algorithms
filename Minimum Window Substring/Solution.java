// https://leetcode.com/problems/minimum-window-substring
// 
// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
// 
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".
// 
// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".
// 
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        char[] array = s.toCharArray();
        int[] windowBucket = new int[128];
        int[] tBucket = new int[128];
        for (char c : t.toCharArray()) tBucket[c - 'A']++;
        int start = 0;
        int end = 0;
        int max = s.length() + t.length();
        int minstart = 0;
        int minend = 0;
        while (end < array.length) {
            windowBucket[array[end++] - 'A']++;
            while (containSubsequence(windowBucket, tBucket)) {
                if (end - start < max) {
                    max = end - start;
                    minstart = start;
                    minend = end;
                }
                windowBucket[array[start++] - 'A']--;
            }
        }
        return s.substring(minstart, minend);
    }

    private boolean containSubsequence(int[] w, int[] t) {
        for (int i = 0; i < 128; i++) {
            if (w[i] < t[i]) return false;
        }
        return true;
    }
}
