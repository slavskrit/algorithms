public class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int result = 0;
        int temp = 0;
        int[] bucket = new int[256];
        for (int i = 0, k = 0; k < s.length();) {
            if (bucket[s.charAt(k)] == 0) {
                bucket[s.charAt(k)]++;
                k++;
                temp++;
                result = Math.max(result, temp);
            } else {
                bucket[s.charAt(i)]--;
                temp--;
                i++;
            }
        }
        return result;
    }
}
