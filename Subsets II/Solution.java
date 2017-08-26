// https://leetcode.com/problems/subsets-ii
// 
// 
// Given a collection of integers that might contain duplicates, nums, return all possible subsets.
// 
// Note: The solution set must not contain duplicate subsets.
// 
// 
// For example,
// If nums = [1,2,2], a solution is:
// 
// 
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
// 
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int current, List<Integer> temp, List<List<Integer>> result) {
        for (int i = current; i < candidates.length; i++) {
            if (i > current && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtrack(candidates, i + 1, temp, result);
            temp.remove(temp.size() - 1);

        }
        result.add(new ArrayList<>(temp));
    }
    
}
