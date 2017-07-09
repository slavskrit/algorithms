public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num < 0) return false;
        if ((num & (num - 1)) == 0) {
            int count = 0;
            while (num != 0) {
                count++;
                num >>>= 1;
            }
            return count % 2 == 1;
        }
        return false;
    }
}
