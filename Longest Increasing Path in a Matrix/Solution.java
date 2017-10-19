// https://leetcode.com/problems/longest-increasing-path-in-a-matrix
// 
// Given an integer matrix, find the length of the longest increasing path.
//
// From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
//
// Example 1:
//
// nums = [
// [9,9,4],
// [6,6,8],
// [2,1,1]
// ]
// Return 4
// The longest increasing path is [1, 2, 6, 9].
//
// Example 2:
//
// nums = [
// [3,4,5],
// [3,2,6],
// [2,2,1]
// ]
// Return 4
// The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
//
// Credits:
// Special thanks to @dietpepsi for adding this problem and creating all test cases.
class Solution {
    
    int maxY;
    int maxX;
    int[][] matrix;

    private int helper(int y, int x, int[][] cache, int previous) {
        if (y < 0 || y >= maxY || x < 0 || x >= maxX || matrix[y][x] >= previous) {
            return 0;
        }
        if (cache[y][x] == 0) {
            int current = matrix[y][x];
            int top = helper(y + 1, x, cache, current);
            int bottom = helper(y - 1, x, cache, current);
            int left = helper(y, x + 1, cache, current);
            int right = helper(y, x - 1, cache, current);
            cache[y][x] = Math.max(top, Math.max(bottom, Math.max(left, right))) + 1;
        }
        return cache[y][x];
    }

    public int longestIncreasingPath(int[][] matrix) {
        this.maxY = matrix.length;
        int result = 0;
        if (maxY == 0) return result;
        this.matrix = matrix;
        this.maxX = matrix[0].length;
        int[][] cache = new int[maxY][maxX];
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                result = Math.max(result, helper(i, j, cache, Integer.MAX_VALUE));
            }
        }
        return result;
    }
}
