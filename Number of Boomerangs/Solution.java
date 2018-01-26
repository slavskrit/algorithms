// https://leetcode.com/problems/number-of-boomerangs
// 
// Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
// 
// Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
// 
// Example:
// Input:
// [[0,0],[1,0],[2,0]]
// 
// Output:
// 2
// 
// Explanation:
// The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int[] first: points) {
            Map<Long, Integer> map = new HashMap<>();
            for (int[] second : points) {
                long distance = getDistance(first, second);
                int t = map.getOrDefault(distance, 0);
                result += t * 2;
                map.put(distance, t + 1);
            }
        }
        return result;
    }
    
    private long getDistance(int[] p1, int[] p2) {
        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
