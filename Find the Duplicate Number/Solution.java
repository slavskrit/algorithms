// https://leetcode.com/problems/find-the-duplicate-number
// 
// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
// 
// Note:
// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n2).
// There is only one duplicate number in the array, but it could be repeated more than once.
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (nums[slow] != nums[fast]) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
