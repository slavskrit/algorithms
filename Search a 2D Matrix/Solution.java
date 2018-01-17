// https://leetcode.com/problems/search-a-2d-matrix
// 
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// 
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,
// 
// Consider the following matrix:
// 
// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int y = matrix.length;
        if (y == 0) return false;
        int x = matrix[0].length;
        if (x == 0) return false;
        int left = 0;
        int right = x * y;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid / x == y) return false;
            if (matrix[mid / x][mid % x] == target) return true;
            else if (matrix[mid / x][mid % x] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
