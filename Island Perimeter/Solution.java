public class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int maxY = grid.length;
        int maxX = grid[0].length;
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                if (grid[y][x] == 1) {
                    if (y == 0) {
                        perimeter++;
                    }
                    if (x == 0) {
                        perimeter++;
                    }
                    if (y == grid.length - 1) {
                        perimeter++;
                    }
                    if (x == grid[y].length - 1) {
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
