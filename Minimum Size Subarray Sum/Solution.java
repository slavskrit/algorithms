// https://leetcode.com/problems/minimum-size-subarray-sum
// 
// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
// 
// For example, given the array [2,3,1,2,4,3] and s = 7,
// the subarray [4,3] has the minimal length under the problem constraint.
// 
// click to show more practice.
// 
// More practice:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
// 
// Credits:
// Special thanks to @Freezen for adding this problem and creating all test cases.
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = Integer.MAX_VALUE;
        int sum = 0;
        int first = 0;
        int second = 0;
        while (second <= nums.length) {
            while (sum >= s) {
                result = Math.min(result, second - first);
                sum -= nums[first];
                first++;
            }
            if (second == nums.length) break;
            sum += nums[second];
            second++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
