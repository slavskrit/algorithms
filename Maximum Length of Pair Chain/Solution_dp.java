// https://leetcode.com/problems/maximum-length-of-pair-chain/description/
// 
// You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.
// 
// Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.
// 
// Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.
// 
// Example 1:
// Input: [[1,2], [2,3], [3,4]]
// Output: 2
// Explanation: The longest chain is [1,2] -> [3,4]
// Note:
// The number of given pairs will be in the range [1, 1000].
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int length = pairs.length;
        int[] dp = new int[length];
        int result = 1;
        for (int i = length - 1; i >= 0; i--) {
            int localMax = 0;
            for (int j = i; j < length; j++) {
                if (pairs[i][1] < pairs[j][0]) {
                    localMax = Math.max(localMax, dp[j]);
                }
            }
            dp[i] = localMax + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
