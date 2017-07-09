public class Solution {
    public int firstUniqChar(String s) {
        if (s.length() == 0) return -1;
        if (s.length() == 1) return 0;
        char[] letters = new char[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letters[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
