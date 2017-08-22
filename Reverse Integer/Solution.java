public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        int negative = x < 0 ? -1 : 1;        
        long result = 0;
        x = Math.abs(x);
        while (x != 0){
            result *= 10;
            result += x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE) return 0;
        return negative * (int) result;
    }
}
