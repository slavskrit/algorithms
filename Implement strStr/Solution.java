// https://leetcode.com/problems/implement-strstr
//
//
// Implement strStr().
//
//
// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
public class Solution {
    
    private static boolean checkStrings(char[] a, char[] b, int i, int bl) {
        for (int start = 0, end = bl - 1; start <= end; start++, end--) {
            if (a[i + start] != b[start] || a[i + bl - start - 1] != b[end]) return false;
        }
        return true;
    }

    public int strStr(String haystack, String needle) {
        if (haystack.isEmpty() && needle.isEmpty()) return 0;
        if (needle.isEmpty()) return 0;
        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();
        int al = a.length;
        int bl = b.length;
        if (al == bl && haystack.equals(needle)) return 0;
        for (int i = 0; i < al - bl + 1; i++) {
            if (checkStrings(a, b, i, bl)) {
                return i;
            }
        }
        return -1;
    }
}
