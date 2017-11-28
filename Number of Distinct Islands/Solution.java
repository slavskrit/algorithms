// https://leetcode.com/problems/number-of-distinct-islands
// 
// Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
// 
// Count the number of distinct islands. An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.
// 
// Example 1:
// 11000
// 11000
// 00011
// 00011
// Given the above grid map, return 1.
// Example 2:
// 11011
// 10000
// 00001
// 11011
// Given the above grid map, return 3.
// 
// Notice that:
// 11
// 1
// and
//  1
// 11
// are considered different island shapes, because we do not consider reflection / rotation.
// Note: The length of each dimension in the given grid does not exceed 50.
class Solution {
    int maxX;
    int maxY;

    public int numDistinctIslands(int[][] grid) {
        maxY = grid.length;
        maxX = grid[0].length;
        Set<Integer> distinctIslands = new HashSet<>();
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (grid[i][j] == 1) {
                    int p = dfs(grid, i, j, 31, 11, 17);
                    distinctIslands.add(p);
                }
            }
        }
        return distinctIslands.size();
    }

    private int dfs(int[][] grid, int y, int x, int hash, int i, int j) {
        if (y >= maxY || x >= maxX || y < 0 || x < 0 || grid[y][x] == 0) return 1;
        hash *= (i * j);
        grid[y][x] = 0;
        hash += dfs(grid, y + 1, x, hash, i + 1, j);
        hash += dfs(grid, y - 1, x, hash, i - 1, j);
        hash += dfs(grid, y, x + 1, hash, i, j + 1);
        hash += dfs(grid, y, x - 1, hash, i, j - 1);
        return hash;
    }
}
