// https://leetcode.com/problems/integer-break
//
// Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
// 
// For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
// 
// Note: You may assume that n is not less than 2 and not larger than 58.
// 
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
class Solution {
    public int integerBreak(int n) {
        int result = 1;
        if (n <= 2) return result;
        if (n == 3) return 2;
        while (n > 1) {
            if (n == 4) {
                result *= 4;
                n -= 4;
            }else if (n >= 3) {
                result *= 3;
                n -= 3;
            } else {
                result *= 2;
                n-= 2;
            }
        }
        return result;
    }
}
