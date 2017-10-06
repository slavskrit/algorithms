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
        int result = 1;
        for (int i = 0, length = nums.length, temp = 0; i < length; i++) {
            while (nums[i] < length && nums[i] > 0 && nums[i] - 1 != i && nums[i] != nums[nums[i] - 1]) {
                temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i : nums) {
            if (i == result) result++;
        }
        return result;
    }
}
