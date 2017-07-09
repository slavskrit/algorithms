public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        if (s.length() == t.length()) return s.equals(t);
        int first = s.length() - 1;
        int second = t.length() - 1;
        while (second > 0) {
            if (first == 0) return true;
            if (t.charAt(second) == s.charAt(first)) {
                first--;
            }
            second--;
        }
        return first == 0;
    }
}
