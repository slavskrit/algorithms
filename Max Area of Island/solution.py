"""
https://leetcode.com/problems/max-area-of-island

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.
"""
class Solution:
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        max_y = len(grid)
        max_x = len(grid[0])
        result = 0
        for y in range(max_y):
            for x in range(max_x):
                if grid[y][x] == 1:
                    queue = [(y, x)]
                    local_max = 0
                    while queue:
                        point = queue.pop()
                        if 0 <= point[0] < max_y and 0 <= point[1] < max_x and grid[point[0]][point[1]] == 1:
                            grid[point[0]][point[1]] = 0
                            local_max += 1
                            queue.append((point[0] + 1, point[1]))
                            queue.append((point[0] - 1, point[1]))
                            queue.append((point[0], point[1] + 1))
                            queue.append((point[0], point[1] - 1))
                    result = max(result, local_max)
        return result
