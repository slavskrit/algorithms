public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 3) return true;
        int left = 0, right = (int) Math.sqrt(c);
        while (left <= right) {
            int mid = left * left + right * right;
            if (mid < c) {
                left++;
            } else if (mid > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }
}
