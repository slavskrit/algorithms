// https://leetcode.com/problems/product-of-array-except-self
// 
// 
// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
// Solve it without division and in O(n).
// For example, given [1,2,3,4], return [24,12,8,6].
// 
// Follow up:
// Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;
        int[] result = new int[length];
        int temp = 1;
        for (int i = 0; i < length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}
