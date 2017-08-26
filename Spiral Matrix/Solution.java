// https://leetcode.com/problems/spiral-matrix
// 
// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
// 
// 
// For example,
// Given the following matrix:
// 
// 
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// 
// 
// You should return [1,2,3,6,9,8,7,4,5].
// 
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return list;
        int m = matrix.length, n = matrix[0].length;
        int u = 0, d = m - 1, l = 0, r = n - 1;
        while (true) {
            // up
            for (int col = l; col <= r; col++){
                list.add(matrix[u][col]);
            }
            if (++u > d) break;
            // right
            for (int row = u; row <= d; row++){
                list.add(matrix[row][r]);
            }
            if (--r < l) break;
            // down
            for (int col = r; col >= l; col--){
                list.add(matrix[d][col]);
            }
            if (--d < u) break;
            // left
            for (int row = d; row >= u; row--){
                list.add(matrix[row][l]);
            }
            if (++l > r) break;
        }
        return list;
    }
}
