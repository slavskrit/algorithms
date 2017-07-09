public class Solution {
    public int longestPalindrome(String s) {
        int a[] = new int[122-64];
        for (char c: s.toCharArray()) {
            a[c - 'A']++;
        }
        int result = 0;
        int one = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) one = 1;
            result += a[i] / 2;
        }
        return result * 2 + one;
    }
}
