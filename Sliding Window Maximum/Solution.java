// https://leetcode.com/problems/sliding-window-maximum
// 
// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
// 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// 
// Therefore, return the max sliding window as [3,3,5,5,6,7].
// Note: 
// You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
// Follow up:
// Could you solve it in linear time?
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (k == 1) return nums;
        if (nums.length == k) {
            int[] array = new int[1];
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (max < nums[i]) max = nums[i];
            }
            array[0] = max;
            return array;
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = k - 1;
        while (right < nums.length) {
            int max = nums[left];
            for (int i = left; i <= right; i++) {
                if (nums[i] > max) max = nums[i];
            }
            result.add(max);
            left++;
            right++;
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;   
    }
}
