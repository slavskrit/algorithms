public class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int y = grid.length;
        if (y == 0) return result;
        int x = grid[0].length;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    helper(grid, i, j, y, x);
                }
            }
        }
        return result;
    }

    private void helper(char[][] grid, int i, int j, int y, int x) {
        if (i < 0 || i >= y || j < 0 || j >= x || grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(grid, i + 1, j, y, x);
        helper(grid, i - 1, j, y, x);
        helper(grid, i, j + 1, y, x);
        helper(grid, i, j - 1, y, x);
    }

}
