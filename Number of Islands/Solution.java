// https://leetcode.com/problems/number-of-islands
// 
// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
// Example 1:
// 11110110101100000000
// Answer: 1
// Example 2:
// 11000110000010000011
// Answer: 3
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.
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
