// https://leetcode.com/problems/powx-n
// 
// Implement pow(x, n).
// 
// 
// Example 1:
// 
// Input: 2.00000, 10
// Output: 1024.00000
// Example 2:
// 
// Input: 2.10000, 3
// Output: 9.26100
class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) return x > 1 ? 0 : 1;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        if ((n & 1) == 1) {
            return x * myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2);
        }
    }
}
