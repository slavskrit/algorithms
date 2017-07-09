public class Solution {
    public int uniquePaths(int m, int n) {
        int map[][] = new int[m][n];
        for(int i = 0; i < n; i++) {
            map[0][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            map[i][0] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int k = 1; k < n; k++) {
                map[i][k] = map[i - 1][k] + map[i][k - 1];
            }
        }
        return map[m - 1][n - 1];
    }
}
