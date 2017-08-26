// https://leetcode.com/problems/longest-consecutive-sequence
// 
// 
// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
// 
// 
// For example,
// Given [100, 4, 200, 1, 3, 2],
// The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
// 
// 
// Your algorithm should run in O(n) complexity.
// 
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) continue;
            int l = map.getOrDefault(i - 1, 0);
            int r = map.getOrDefault(i + 1, 0);
            int temp = l + r + 1; // at least 1 consecutive digit is current digit itself
            map.put(i, temp);
            map.put(i - l, temp);
            map.put(i + r, temp);
            result = Math.max(result, temp);
        }
        return result;
    }
}
