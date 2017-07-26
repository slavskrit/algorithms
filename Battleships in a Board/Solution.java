public class Solution {
    public int countBattleships(char[][] board) {
        int result = 0;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == '.' 
                    || x > 0 && board[y][x - 1] == 'X' 
                    || y > 0 && board[y -1][x] == 'X' ) continue;
                result++;
            }
        }
        return result;
    }
}
