// https://leetcode.com/problems/partition-to-k-equal-sum-subsets
// 
// Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
// 
// Example 1:
// Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
// Output: True
// Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
// Note:
// 
// 1 <= k <= len(nums) <= 16.
// 0 < nums[i] < 10000.
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return false;
        int sum = 0;
        for (int i : nums) sum += i;
        return sum % k == 0 && dfs(nums, sum / k, 0, 0, k, new boolean[nums.length]);
    }

    private boolean dfs(int[] nums, int target, int cursor, int sum, int k, boolean[] visited) {
        if (k == 1) return true;
        if (sum == target) {
            return dfs(nums, target, 0, 0, k - 1, visited);
        }
        for (int i = cursor; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(nums, target, i + 1, sum + nums[i], k, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
