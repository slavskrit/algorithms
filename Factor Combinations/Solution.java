// https://leetcode.com/problems/factor-combinations
// 
// Numbers can be regarded as product of its factors. For example,
// 
// 8 = 2 x 2 x 2;
//   = 2 x 4.
// Write a function that takes an integer n and return all possible combinations of its factors.
// 
// Note: 
// You may assume that n is always positive.
// Factors should be greater than 1 and less than n.
// Examples: 
// input: 1
// output: 
// []
// input: 37
// output: 
// []
// input: 12
// output:
// [
//   [2, 6],
//   [2, 2, 3],
//   [3, 4]
// ]
// input: 32
// output:
// [
//   [2, 16],
//   [2, 2, 8],
//   [2, 2, 2, 4],
//   [2, 2, 2, 2, 2],
//   [2, 4, 4],
//   [4, 8]
// ]
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> temp = new ArrayDeque<>();
        backtrack(result, n, temp, 2);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int n, Deque<Integer> temp, int cursor) {
        if (n == 1) {
            if (temp.size() > 1) result.add(new ArrayList<>(temp));
        } else {
            for (int i = cursor; i <= n; i++) {
                if (n % i == 0) {
                    temp.push(i);
                    backtrack(result, n / i, temp, i);
                    temp.pop();
                }
            }
        }
    }
}
