// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
// 
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
// Find the minimum element.
// You may assume no duplicate exists in the array.
public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (left < right) {
            if (nums[left] < nums[right]) return nums[left];
            mid = (left + right) / 2;
            if (nums[mid] >= nums[left])
                left = mid + 1;
            else 
                right = mid;
        }
        return nums[left];
    }
}
