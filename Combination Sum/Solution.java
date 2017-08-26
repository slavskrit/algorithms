// https://leetcode.com/problems/combination-sum
// 
// 
// Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T. 
// 
// The same repeated number may be chosen from C unlimited number of times.
// 
// Note:
// 
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// 
// 
// 
// For example, given candidate set [2, 3, 6, 7] and target 7, 
// A solution set is: 
// 
// [
//   [7],
//   [2, 2, 3]
// ]
// 
// 
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        recursion(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void recursion(ArrayList<List<Integer>> result, int[] candidates, int target, List<Integer> temp, int s) {
        if (target < 0) return;
        else if (target == 0) {
            result.add(new ArrayList<>(temp));
        }
        else {
            for (int i = s; i < candidates.length; i++) {
                temp.add(candidates[i]);
                recursion(result, candidates, target - candidates[i], temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
