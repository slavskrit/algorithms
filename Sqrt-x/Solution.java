// https://leetcode.com/problems/sqrtx
//
// Implement int sqrt(int x).
// Compute and return the square root of x.
public class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int l = 1, r = x;
        while (true) {
            int mid = l + (r - l) / 2;
            if (mid > x / mid) {
                r = mid - 1;
            } else {
                if (++mid > x / mid) {
                    return --mid;
                }
                l = mid;
            }
        }
    }
}
