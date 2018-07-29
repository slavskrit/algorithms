// https://leetcode.com/problems/reordered-power-of-2/description/
// 
// Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.
// 
// Return true if and only if we can do this in a way such that the resulting number is a power of 2.
// 
//  
// 
// Example 1:
// 
// Input: 1
// Output: true
// Example 2:
// 
// Input: 10
// Output: false
// Example 3:
// 
// Input: 16
// Output: true
// Example 4:
// 
// Input: 24
// Output: false
// Example 5:
// 
// Input: 46
// Output: true
//  
// 
// Note:
// 
// 1 <= N <= 10^9
class Solution {
    public boolean reorderedPowerOf2(int N) {
        Set<Map<Integer, Integer>> set = new HashSet<>();
        for (int i = 1, j = 0; j++ < 31; i <<= 1) {
            Map<Integer, Integer> map = new HashMap<>();
            int k = i;
            while (k > 0) {
                map.put(k % 10, map.getOrDefault(k % 10, 0) + 1);
                k /= 10;
            }
            set.add(map);
        }
        Map<Integer, Integer> map = new HashMap<>();
        while (N > 0) {
            map.put(N % 10, map.getOrDefault(N % 10, 0) + 1);
            N /= 10;
        }
        return set.contains(map);
    }
}
