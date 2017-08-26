// https://leetcode.com/problems/k-diff-pairs-in-an-array
// 
// 
// Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
// 
// Example 1:
// 
// Input: [3, 1, 4, 1, 5], k = 2
// Output: 2
// Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) result++;
            } else {
                if (map.containsKey(entry.getKey() + k)) result++;
            }
        }
        return result;
    }
}
