// https://leetcode.com/problems/increasing-subsequences
// 
// Given an integer array, your task is to find all the different possible increasing subsequences of the given array, and the length of an increasing subsequence should be at least 2 .
// 
// Example:
// Input: [4, 6, 7, 7]
// Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
// Note:
// The length of the given array will not exceed 15.
// The range of integer in the given array is [-100,100].
// The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int cursor, int[] nums, LinkedList<Integer> temp, List<List<Integer>> result) {
        if (temp.size() > 1) result.add(new ArrayList<>(temp));
        Set<Integer> used = new HashSet<>();
        for (int i = cursor; i < nums.length; i++) {
            if (!used.contains(nums[i])) {
                if (temp.isEmpty() || temp.peekLast() <= nums[i]) {
                    used.add(nums[i]);
                    temp.offerLast(nums[i]);
                    dfs(i + 1, nums, temp, result);
                    temp.pollLast();
                }
            }
        }
    }
}
