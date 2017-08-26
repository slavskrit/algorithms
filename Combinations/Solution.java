// https://leetcode.com/problems/combinations
// 
// 
// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
// 
// 
// For example,
// If n = 4 and k = 2, a solution is:
// 
// 
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
// 
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int n, int k, int current, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = current; i < n; i++) {
            temp.add(i + 1);
            backtrack(n, k, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
