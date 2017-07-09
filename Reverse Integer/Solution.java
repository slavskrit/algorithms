public class Solution {
    public int reverse(int x) {
        long k = x;
        boolean isNegtive = false;        
        if(k < 0){
            k = 0 - k;
            isNegtive = true;
        }

        long result = 0;
        while(k != 0){
            result *= 10;
            result += k % 10;
            k /= 10;
        }

        if(result > Integer.MAX_VALUE) return 0;
        return isNegtive  ? 0 - ((int)result) : (int)result;
        
    }
}
