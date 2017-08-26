// https://leetcode.com/problems/search-for-a-range
// 
// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
// Your algorithm's runtime complexity must be in the order of O(log n).
// If the target is not found in the array, return [-1, -1].
// 
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].
// 
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = {-1, -1};
        if(nums.length == 0) return result;
        
        while (left < right) {
            int mid = (left + right) /2;
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        
        if (nums[left] != target) return result;
        else result[0] = left;

        right = nums.length - 1;
        
        while (left < right) {
            int mid = (left + right) /2 + 1;	
            if (nums[mid] > target) right = mid - 1;
            else left = mid;
        }
        result[1] = right;
        return result;
    }
}
