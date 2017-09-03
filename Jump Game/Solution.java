// https://leetcode.com/problems/jump-game
// 
// Given an array of non-negative integers, you are initially positioned at the first index of the array.
// 
// Each element in the array represents your maximum jump length at that position.
// 
// Determine if you are able to reach the last index.
// 
// For example:
// A = [2,3,1,1,4], return true.
// 
// A = [3,2,1,0,4], return false.
class Solution {
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length < 2) return true;
        int sum = nums[0];
        for (int i = 1; i < length - 1; i++) {
            if (sum == 0 && nums[i - 1] == 0) return false;
            if (sum-- >= length) return true;
            sum = Math.max(nums[i], sum);
        }
        return sum > 0;
    }
}
