// https://leetcode.com/problems/one-edit-distance
// 
// Given two strings S and T, determine if they are both one edit distance apart.
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null && t == null) return false;
        if (s == null || t == null) return false;
        if (s.equals(t)) return false;
        if (s.length() == t.length()) return isSameAfterChangeOneLetter(s, t);
        return isSameAfterDeleteOneChar(s, t);
    }

    private boolean isSameAfterDeleteOneChar(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;
        for (int i = 0; i < s.length() && i < t.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(i).equals(t.substring(i + 1)) || s.substring(i + 1).equals(t.substring(i));
            }
        }
        return true;
    }

    private boolean isSameAfterChangeOneLetter(String s, String t) {
        boolean foundOneLetter = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (foundOneLetter) return false;
                foundOneLetter = true;
            }
        }
        return foundOneLetter;
    }
}
