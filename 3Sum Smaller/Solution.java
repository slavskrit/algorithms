// https://leetcode.com/problems/3sum-smaller
// 
// Given an array of n integers nums and a target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
// 
// For example, given nums = [-2, 0, 1, 3], and target = 2.
// 
// Return 2. Because there are two triplets which sums are less than 2:
// 
// [-2, 0, 1]
// [-2, 0, 3]
// Follow up:
// Could you solve it in O(n2) runtime?
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int left = i + 1;
            int right = length - 1;
            while (left < right) {
                while (nums[i] + nums[left] + nums[right] < target && left < right) {
                    result += right - left;
                    left++;
                }
                right--;
            }
        }
        return result;
    }
}
