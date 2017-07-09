public class Solution {

    private int max;
    private int cursor;

    private void isPalindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        if (max < end - start - 1) {
            cursor = start + 1;
            max = end - start - 1;
        }
    }

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome(s, i, i);
            isPalindrome(s, i, i + 1);
        }
        return s.substring(cursor, cursor + max);
    }
}
