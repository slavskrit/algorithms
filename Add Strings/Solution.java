public class Solution {
    public String addStrings(String num1, String num2) {
        String greater = num1.length() > num2.length() ? num1 : num2;
        String smaller = greater == num1 ? num2 : num1;
        char[] result = new char[greater.length() + 1];
        int s = smaller.length() - 1;
        boolean overflow = false;
        int carry = result.length - 1;
        for (int i = greater.length() - 1; i >= 0; i--) {
            int t = 0;
            if (s >= 0) {
                t = greater.charAt(i) + smaller.charAt(s) - '0' - '0';
                s--;
            } else {
                t = greater.charAt(i) - '0';
            }
            if (overflow) {
                t++;
                overflow = false;
            }
            if (t > 9) {
                overflow = true;
            }
            result[carry] = (char) ((t % 10) + '0');
            carry--;
        }
        if (overflow){
            result[0] = '1';
            return new String(result);
        } else {
            return new String(result, 1, result.length - 1);
        }
    }
}
