public class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == 1) {
                    if (y == 0) {
                        perimeter++;
                    }
                    if (x == 0) {
                        perimeter++;
                    }
                    if (grid.length - 1 == y) {
                        perimeter++;
                    }
                    if (grid[y].length - 1 == x) {
                        perimeter++;
                    }
                    if (x > 0) {
                        if (grid[y][x - 1] == 0) {
                            perimeter++;
                        }
                    }
                    if (x < grid[y].length - 1) {
                        if (grid[y][x + 1] == 0 ) {
                            perimeter++;
                        }
                    }
                    if (y > 0) {
                        if (grid[y - 1][x] == 0) {
                            perimeter++;
                        }
                    }
                    if (y < grid.length - 1) {
                        if (grid[y + 1][x] == 0 ) {
                            perimeter++;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}
