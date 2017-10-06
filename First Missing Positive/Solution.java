// https://leetcode.com/problems/first-missing-positive
// 
// Given an unsorted integer array, find the first missing positive integer.
// 
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
// 
// Your algorithm should run in O(n) time and uses constant space.
public class Solution {
    public int firstMissingPositive(int[] nums) {
        boolean isEqualToLength = false;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            while (value > 0 && value < nums.length && nums[value] != value) {
                int temp = nums[value];
                nums[value] = value;
                value = temp;
            }
            if (value >= nums.length || value < 0) {
                if (value == nums.length) {
                    isEqualToLength = true;
                }
                nums[i] = 0;
            }
        }
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == result) {
                result++;
            }
        }
        if (isEqualToLength && result == nums.length) result++;
        return result;
    }
}
