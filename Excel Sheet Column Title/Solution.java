public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) return "";
        StringBuilder result = new StringBuilder();
        while (n-- > 0) {
            result.insert(0, (char) (n % 26 + 'A'));
            n /= 26;
        }
        return result.toString();
    }
}
