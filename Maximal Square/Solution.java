// https://leetcode.com/problems/maximal-square
// 
// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
// 
// For example, given the following matrix:
// 
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
// Return 4.
// Credits:
// Special thanks to @Freezen for adding this problem and creating all test cases.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) return 0;
        int columns = matrix[0].length;
        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    int left = j > 0 ? matrix[i][j - 1]  - '0' : 0;
                    int top = i > 0 ? matrix[i - 1][j] - '0' : 0;
                    int corner = i > 0 && j > 0 ? matrix[i - 1][j - 1] - '0' : 0;
                    matrix[i][j] = (char) (Math.min(Math.min(left, top), corner) + 1 + '0');
                    result = Math.max(matrix[i][j] - '0', result);
                }
            }
        }
        return result * result;
    }
}
