// https://leetcode.com/problems/count-of-smaller-numbers-after-self
// 
// You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
// 
// Example:
// 
// Given nums = [5, 2, 6, 1]
// 
// To the right of 5 there are 2 smaller elements (2 and 1).
// To the right of 2 there is only 1 smaller element (1).
// To the right of 6 there is 1 smaller element (1).
// To the right of 1 there is 0 smaller element.
// Return the array [2, 1, 1, 0].
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int min = nums[0];
        int max = nums[0];
        for (int i : nums) {
            result.add(0);
            min = Math.min(min, i);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] += Math.abs(min);
            max = Math.max(max, nums[i]);
        }
        int[] bit = new int[max + 1];
        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            index = nums[i];
            int temp = 0;
            while (index > 0) {
                temp += bit[index];
                index -= index & (-index);
            }
            result.set(i, temp);
            index = nums[i] + 1;
            while (index < bit.length) {
                bit[index] += 1;
                index += index & (-index);
            }
        }
        return result;
    }
}
