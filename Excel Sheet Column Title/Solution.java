public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        if (n == 0) return result.toString();
        while (n > 0) {
            n--;
            result.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return result.reverse().toString();
    }
}
