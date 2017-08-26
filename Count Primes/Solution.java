// https://leetcode.com/problems/count-primes
// 
// Description:
// Count the number of prime numbers less than a non-negative number, n.
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.
public class Solution {
    public int countPrimes(int n) {
        boolean[] dp = new boolean[n];
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (!dp[i]) result++;
            for (int j = 2; i * j < n; j++) {
                dp[i * j] = true;
            }
        }
        return result;
    }
}
