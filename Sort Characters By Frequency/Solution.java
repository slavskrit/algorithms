public class Solution {
    public String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        while (sb.length() != s.length()) {
            int max = 0;
            char c = ' ';
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] > max) {
                    max = hash[i];
                    c = (char) i;
                }
            }
            hash[c] = 0;
            while (--max > -1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
