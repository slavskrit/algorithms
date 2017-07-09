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
