// https://leetcode.com/problems/3sum-closest
// 
// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
// 
//     For example, given array S = {-1 2 1 -4}, and target = 1.
// 
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int temp = -nums[i];
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (Math.abs(target - result) > Math.abs(target - sum)) {
                    result = sum;
                    if (result == target) {
                        return result;
                    }
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
