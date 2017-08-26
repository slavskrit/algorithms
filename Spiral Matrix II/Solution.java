// https://leetcode.com/problems/spiral-matrix-ii
// 
// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
// 
// For example,
// Given n = 3,
// 
// You should return the following matrix:
// 
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
// 
public class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        if (n == 0) return matrix;
        int u = 0, d = n - 1, l = 0, r = n - 1;
        int f = 1;
        while (f <= n * n) {
            // up
            for (int col = l; col <= r; col++){
                matrix[u][col] = f++;
            }
            if (++u > d) break;
            // right
            for (int row = u; row <= d; row++){
                matrix[row][r] = f++;
            }
            if (--r < l) break;
            // down
            for (int col = r; col >= l; col--){
                matrix[d][col] = f++;
            }
            if (--d < u) break;
            // left
            for (int row = d; row >= u; row--){
                matrix[row][l] = f++;
            }
            if (++l > r) break;
        }
        return matrix;
    }
}
