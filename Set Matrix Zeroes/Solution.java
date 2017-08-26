// https://leetcode.com/problems/set-matrix-zeroes
// 
// 
// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
// 
// click to show follow up.
// Follow up:
// 
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?
// 
// 
public class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean[] x = new boolean[rows];
        boolean[] y = new boolean[columns];
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                if (matrix[i][k] == 0) {
                    x[i] = true;
                    y[k] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int k = 0; k < columns; k++) {
                if (x[i] || y[k]) matrix[i][k] = 0;
            }
        }
    }
}
