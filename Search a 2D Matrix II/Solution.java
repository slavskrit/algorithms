// https://leetcode.com/problems/search-a-2d-matrix-ii
// 
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
// 
// 
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
// 
// 
// 
// For example,
// 
// Consider the following matrix:
// 
// 
// [
//   [1,   4,  7, 11, 15],
//   [2,   5,  8, 12, 19],
//   [3,   6,  9, 16, 22],
//   [10, 13, 14, 17, 24],
//   [18, 21, 23, 26, 30]
// ]
// 
// Given target = 5, return true.
// Given target = 20, return false.
public class Solution {
    private boolean binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;
        if (min == max && array[0] == target) return true;
        while (min < max) {
            int mid = min + (max - min / 2);
            if (array[min] == target || array[mid] == target || array[max] == target) return true;
            if (array[mid] > target) {
                max = mid - 1;
            }
            if (array[mid] < target) {
                min = mid;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0 && matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                if (binarySearch(matrix[i], target)) return true;
            }
        }
        return false;
    }
}
