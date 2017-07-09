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
