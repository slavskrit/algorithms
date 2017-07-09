public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        double multiplicator;
        for (int i = 0; i < s.length(); i++) {
            multiplicator = Math.pow(26, s.length() - i - 1);
            if (multiplicator == 0) {
                result += s.charAt(i) - 'A' + 1 ;
            } else {
                result += (s.charAt(i) - 'A' + 1) * multiplicator ;
            }

        }
        return result;
    }
}
