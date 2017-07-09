public class Solution {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int y = board.length;
        int x = board[0].length;
        for (int i = 0; i < y; i++){
            if (board[i][0] == 'O') board[i][0] = 'S';
            if (board[i][x - 1] == 'O') board[i][x - 1] = 'S';
        }
        for (int i = 0; i < x; i++){
            if (board[0][i] == 'O') board[0][i] = 'S';
            if (board[y - 1][i] == 'O') board[y - 1][i] = 'S';
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 1; i < y - 1; i++) {
            for (int k = 1; k < x - 1; k++) {
                if (board[i][k] == 'O') {
                    if (board[i + 1][k] == 'S' ||
                        board[i - 1][k] == 'S' ||
                        board[i][k + 1] == 'S' ||
                        board[i][k - 1] == 'S') queue.add(new int[]{i, k});
                }
                while (!queue.isEmpty()) {
                    int[] t = queue.poll();
                    board[t[0]][t[1]] = 'S';
                    if (board[t[0] + 1][t[1]] == 'O') {
                        board[t[0] + 1][t[1]] = 'S';
                        queue.add(new int[]{t[0] + 1, t[1]});
                    }
                    if (board[t[0] - 1][t[1]] == 'O') {
                        board[t[0] - 1][t[1]] = 'S';
                        queue.add(new int[]{t[0] - 1, t[1]});
                    }
                    if (board[t[0]][t[1] + 1] == 'O') {
                        board[t[0]][t[1] + 1] = 'S';
                        queue.add(new int[]{t[0], t[1] + 1});
                    }
                    if (board[t[0]][t[1] - 1] == 'O') {
                        board[t[0]][t[1] - 1] = 'S';
                        queue.add(new int[]{t[0], t[1] - 1});
                    }
                }
            }
        }


        for (int i = 0; i < y; i++) {
            for (int k = 0; k < x; k++) {
                if (board[i][k] == 'O') board[i][k] = 'X';
                if (board[i][k] == 'S') board[i][k] = 'O';
            }
        }
    }
}
