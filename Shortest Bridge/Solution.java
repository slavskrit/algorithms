// https://leetcode.com/problems/shortest-bridge/description/
// 
// In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
// 
// Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
// 
// Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
// 
//  
// 
// Example 1:
// 
// Input: [[0,1],[1,0]]
// Output: 1
// Example 2:
// 
// Input: [[0,1,0],[0,0,0],[0,0,1]]
// Output: 2
// Example 3:
// 
// Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
// Output: 1
//  
// 
// Note:
// 
// 1 <= A.length = A[0].length <= 100
// A[i][j] == 0 or A[i][j] == 1
class Solution {
    public int shortestBridge(int[][] A) {
        int l = A.length;
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] firstIsland = findIsland(A, l);
        dfs(firstIsland[0], firstIsland[1], l, A, queue);
        while (!queue.isEmpty()) {
            Queue<int[]> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];
                if (i > 0 && A[i - 1][j] == 1
                        || j > 0 && A[i][j - 1] == 1
                        || i < l - 1 && A[i + 1][j] == 1
                        || j < l - 1 && A[i][j + 1] == 1) {
                    System.out.println(result);
                    return result;
                }
                A[i][j] = result + 2;
                if (i > 0 && A[i - 1][j] == 0) {
                    A[i - 1][j] = 3;
                    temp.add(new int[]{i - 1, j});
                }
                if (j > 0 && A[i][j - 1] == 0) {
                    A[i][j - 1] = 3;
                    temp.add(new int[]{i, j - 1});
                }
                if (i < l - 1 && A[i + 1][j] == 0) {
                    A[i + 1][j] = 3;
                    temp.add(new int[]{i + 1, j});
                }
                if (j < l - 1 && A[i][j + 1] == 0) {
                    A[i][j + 1] = 3;
                    temp.add(new int[]{i, j + 1});
                }
            }
            result++;
            queue = temp;
        }
        return result;
    }

    private int[] findIsland(int[][] A, int l) {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (A[i][j] == 1) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    private void dfs(int i, int j, int l, int[][] A, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i >= l || j >= l || A[i][j] != 1) return;
        if (i < l - 1 && A[i + 1][j] == 0
                || j < l - 1 && A[i][j + 1] == 0
                || i > 0 && A[i - 1][j] == 0
                || j > 0 && A[i][j - 1] == 0) {
            queue.add(new int[]{i, j});
        }
        A[i][j] = -1;
        dfs(i + 1, j, l, A, queue);
        dfs(i - 1, j, l, A, queue);
        dfs(i, j + 1, l, A, queue);
        dfs(i, j - 1, l, A, queue);
    }
}
