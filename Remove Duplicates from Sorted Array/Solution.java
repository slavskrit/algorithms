// https://leetcode.com/problems/remove-duplicates-from-sorted-array
// 
// 
// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
// 
// Do not allocate extra space for another array, you must do this in place with constant memory.
// 
// 
// For example,
// Given input array nums = [1,1,2],
// 
// 
// Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
// 
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int slow = 1;
        for (int fast = slow; fast < nums.length; ++fast) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
