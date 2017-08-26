// https://leetcode.com/problems/combination-sum-iii
// 
// 
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
// 
// 
// 
//  Example 1:
// Input:  k = 3,  n = 7
// Output: 
// 
// [[1,2,4]]
// 
// 
//  Example 2:
// Input:  k = 3,  n = 9
// Output: 
// 
// [[1,2,6], [1,3,5], [2,3,4]]
// 
// 
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.
public class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] values = new int[]{1,2,3,4,5,6,7,8,9};
        backtrack(values, k, n, new ArrayList<>(), 0, 0);
        return result;
    }

    private void backtrack(int[] values, int k, int n, List<Integer> temp, int current, int start) {
        if (k == temp.size()) {
            if (current == n) {
                result.add(new ArrayList<>(temp));
            }
        } else {
            for (int i = start; i < values.length; i++) {
                temp.add(values[i]);
                backtrack(values, k, n, temp, current + values[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
