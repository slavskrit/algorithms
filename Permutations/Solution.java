// https://leetcode.com/problems/permutations
// 
// 
// Given a collection of distinct numbers, return all possible permutations.
// 
// 
// For example,
// [1,2,3] have the following permutations:
// 
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
// 
// 
public class Solution {
    
    int[] nums;
    List<List<Integer>> result = new ArrayList<>();

    private void swap(int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        permute(0, nums.length - 1);
        return result;
    }

    private void permute(int left, int right) {
        if (left == right) {
            List<Integer> temp = new ArrayList<>();
            for (int i : nums) temp.add(i);
            result.add(temp);
        }
        else {
            for (int i = left; i <= right; i++) {
                swap(left, i);
                permute(left + 1, right);
                swap(i, left);
            }
        }
    }
}
