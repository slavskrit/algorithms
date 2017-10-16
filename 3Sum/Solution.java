// https://leetcode.com/problems/3sum
// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
// 
// Note: The solution set must not contain duplicate triplets.
// 
// For example, given array S = [-1, 0, 1, 2, -1, -4],
// 
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int mid = nums[left] + nums[right];
                if (mid > target) {
                    right--;
                } else {
                    if (mid == target) {
                        if (result.size() > 0) {
                            List<Integer> temp = result.get(result.size() - 1);
                            if (temp.get(0) == nums[i]
                                    && temp.get(1) == nums[left]
                                    && temp.get(2) == nums[right]) {
                                left++;
                                continue;
                            }
                        }
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    left++;
                }
            }
        }
        return result; 
    }
}
