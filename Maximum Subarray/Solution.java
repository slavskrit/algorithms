// https://leetcode.com/problems/maximum-subarray
// 
// 
// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
// 
// 
// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.
// 
// click to show more practice.
// More practice:
// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
// 
public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int result = Integer.MIN_VALUE;
        int helper = Integer.MIN_VALUE;
        int temp = 0;
        for (int i : nums) {
            helper = Math.max(helper, i);
            result = Math.max(result, temp);
            if (temp + i < 0) {
                temp = 0;
            } else {
                temp += i;
            }
        }
        int max = Math.max(result, temp);
        return max == 0 ? helper : Math.max(result, temp);
    }
}
