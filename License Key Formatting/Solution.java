public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        int k = K;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) != '-') {
                if (k == 0) {
                    k = K;
                    sb.append('-');
                }
                sb.append(Character.toUpperCase(S.charAt(i)));
                k--;
            }
        }
        return sb.reverse().toString();
    }
}
