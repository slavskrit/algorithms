// https://leetcode.com/problems/longest-increasing-subsequence
// 
// 
// Given an unsorted array of integers, find the length of longest increasing subsequence.
// 
// 
// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.
// 
// 
// Your algorithm should run in O(n2) complexity.
// 
// Follow up: Could you improve it to O(n log n) time complexity? 
// Credits:Special thanks to @pbrother for adding this problem and creating all test cases.
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        int result = 1;
        for (int i = length - 1; i >= 0; i--) {
            int localMax = 0;
            // Find a greater int with max value
            for (int j = i; j < length; j++) {
                if (nums[i] < nums[j]) {
                    localMax = Math.max(localMax, dp[j]);
                }
            }
            dp[i] = localMax + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
