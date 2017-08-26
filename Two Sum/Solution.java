// https://leetcode.com/problems/two-sum
// 
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// 
// Example:
// 
// Given nums = [2, 7, 11, 15], target = 9,
// 
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
// 
// 
public class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int first = -1;
        int second = -1;
        if (length == 0) return new int[]{first, second};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                first = map.get(target - nums[i]);
                second = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{first, second};
    }
}
