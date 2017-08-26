// https://leetcode.com/problems/island-perimeter
// 
// You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
// Example:
// 
// [[0,1,0,0],
//  [1,1,1,0],
//  [0,1,0,0],
//  [1,1,0,0]]
// 
// Answer: 16
// Explanation: The perimeter is the 16 yellow stripes in the image below:
// 
// 
// 
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
