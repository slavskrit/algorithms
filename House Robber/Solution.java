// https://leetcode.com/problems/house-robber
// 
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
// Credits:Special thanks to @ifanchu for adding this problem and creating all test cases. Also thanks to @ts for adding additional test cases.
public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
            nums[i - 1] = Math.max(nums[i - 1], nums[i - 2]);
        }
        return Math.max(nums[length - 1], nums[length - 2]);
    }
}
