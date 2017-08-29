// https://leetcode.com/problems/maximum-average-subarray-i
//
// Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
//
// Example 1:
// Input: [1,12,-5,-6,50,3], k = 4
// Output: 12.75
// Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
// Note:
// 1 <= k <= n <= 30,000.
// Elements of the given array will be in the range [-10,000, 10,000].
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        double result = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        double sum = 0;
        while (right < nums.length) {
            if (right < k) {
                sum += nums[right];
            } else {
                result = Math.max(sum / k, result);
                sum += nums[right];
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return Math.max(sum / k, result);
    }
}
