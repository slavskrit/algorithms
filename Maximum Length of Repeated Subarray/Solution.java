// https://leetcode.com/problems/maximum-length-of-repeated-subarray
// 
// Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
// 
// Example 1:
// Input:
// A: [1,2,3,2,1]
// B: [3,2,1,4,7]
// Output: 3
// Explanation: 
// The repeated subarray with maximum length is [3, 2, 1].
// Note:
// 1 <= len(A), len(B) <= 1000
// 0 <= A[i], B[i] < 100
class Solution {
    public int findLength(int[] A, int[] B) {
        int y = A.length;
        int x = B.length;
        int[][] dp = new int[y + 1][x + 1];
        int result = 0;
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }
}
