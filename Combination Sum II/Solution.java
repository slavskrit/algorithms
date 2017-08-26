// https://leetcode.com/problems/combination-sum-ii
// 
// 
// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
// 
// Each number in C may only be used once in the combination.
// 
// Note:
// 
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// 
// 
// 
// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
// A solution set is: 
// 
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
// 
// 
public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int current, List<Integer> temp,List<List<Integer>> result) {
        if (target < 0 || current > candidates.length) return;
        if (0 == target) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = current; i < candidates.length; i++) {
                if (i > current && candidates[i] == candidates[i - 1]) continue;
                temp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, temp, result);
                temp.remove(temp.size() - 1);

            }
        }
    }

}
