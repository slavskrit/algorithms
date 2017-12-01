// https://leetcode.com/problems/walls-and-gates
// 
// You are given a m x n 2D grid initialized with these three possible values.
// 
// -1 - A wall or an obstacle.
// 0 - A gate.
// INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
// Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
// 
// For example, given the 2D grid:
// INF  -1  0  INF
// INF INF INF  -1
// INF  -1 INF  -1
//   0  -1 INF INF
// After running your function, the 2D grid should be:
//   3  -1   0   1
//   2   2   1  -1
//   1  -1   2  -1
//   0  -1   3   4
class Solution {
    public void wallsAndGates(int[][] rooms) {
        int maxY = rooms.length;
        if (maxY == 0) return;
        int maxX = rooms[0].length;
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (rooms[i][j] == 0) {
                    Queue<int[]> queue = new LinkedList<>();
                    int distance = -1;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        distance++;
                        while (size-- > 0) {
                            int[] current = queue.poll();
                            if (current[0] > 0 && rooms[current[0] - 1][current[1]] > distance) {
                                queue.offer(new int[]{current[0] - 1, current[1]});
                            }
                            if (current[0] < maxY - 1 && rooms[current[0] + 1][current[1]] > distance) {
                                queue.offer(new int[]{current[0] + 1, current[1]});
                            }
                            if (current[1] > 0 && rooms[current[0]][current[1] - 1] > distance) {
                                queue.offer(new int[]{current[0], current[1] - 1});
                            }
                            if (current[1] < maxX - 1 && rooms[current[0]][current[1] + 1] > distance) {
                                queue.offer(new int[]{current[0], current[1] + 1});
                            }
                            rooms[current[0]][current[1]] = Math.min(rooms[current[0]][current[1]], distance);
                        }
                    }
                }
            }
        }
    }
}
