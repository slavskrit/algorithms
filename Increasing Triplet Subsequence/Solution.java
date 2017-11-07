// https://leetcode.com/problems/increasing-triplet-subsequence
// 
// Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
// 
// Formally the function should:
// Return true if there exists i, j, k 
// such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
// Your algorithm should run in O(n) time complexity and O(1) space complexity.
// 
// Examples:
// Given [1, 2, 3, 4, 5],
// return true.
// 
// Given [5, 4, 3, 2, 1],
// return false.
// 
// Credits:
// Special thanks to @DjangoUnchained for adding this problem and creating all test cases.
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int left = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > middle) {
                if (left < middle) return true;
            } else {
                if (nums[i] < middle && nums[i] > left) {
                    middle = nums[i];
                } else if (nums[i] < left) {
                    if (i < nums.length - 2) {
                        left = nums[i];
                    }
                }
            }
        }
        return false;
    }
}
