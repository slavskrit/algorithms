// https://leetcode.com/problems/unique-paths-ii
// 
// Follow up for "Unique Paths":
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
// For example,
// There is one obstacle in the middle of a 3x3 grid as illustrated below.
// 
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// 
// The total number of unique paths is 2.
// Note: m and n will be at most 100.
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int y = obstacleGrid.length;
        int x = obstacleGrid[0].length;
        for (int i = 0; i < y; i++) {
            for (int k = 0; k < x; k++) {
                if (obstacleGrid[i][k] == 1) obstacleGrid[i][k] = -1;
            }
        }
        if (obstacleGrid[y - 1][x - 1] < 0 || obstacleGrid[0][0] < 0) return 0;
        int step = 0;
        for (int i = 0; i < y; i++) {
            for (int k = 0; k < x; k++) {
                if (obstacleGrid[i][k] >= 0) {
                    if (i == 0 && k == 0) {
                        obstacleGrid[i][k] = 1;
                    } else if (i == 0) {
                        obstacleGrid[i][k] = obstacleGrid[i][k - 1] > 0 ? 1 : 0;
                    } else if (k == 0) {
                        obstacleGrid[i][k] = obstacleGrid[i - 1][k] > 0 ? 1 : 0;
                    }
                    else {
                        int a = obstacleGrid[i - 1][k] >= 0 ? obstacleGrid[i - 1][k] : 0;
                        int b = obstacleGrid[i][k - 1] >= 0 ? obstacleGrid[i][k - 1] : 0;
                        obstacleGrid[i][k] =  a + b;
                    }
                    step++;
                }
            }
        }
        return step == 0 ? 0 : obstacleGrid[y - 1][x - 1];
    }
}
