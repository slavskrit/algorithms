class NumMatrix {

    int[][] matrix;
    
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        int height = matrix.length;
        if(height == 0) return;
        int width = matrix[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int top = helper(i - 1, j);
                int left = helper(i, j - 1);
                int corner = helper(i - 1, j - 1);
                matrix[i][j] += top + left - corner;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return helper(row2, col2) - helper(row1 - 1, col2) - helper(row2, col1 - 1) + helper(row1 - 1, col1 - 1);
    }

    private int helper(int i, int j) {
        return i < 0 || j < 0 ? 0 : matrix[i][j];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
