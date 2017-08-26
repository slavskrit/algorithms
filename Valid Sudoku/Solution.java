// https://leetcode.com/problems/valid-sudoku
// 
// Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
// 
// 
// A partially filled sudoku which is valid.
// 
// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
// 
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] helper = new int[10];
        // hor
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] != '.') helper[board[i][k] - '0']++;
            }
            if (isFalse(helper)) return false;
        }
        // vert
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[k][i] != '.') helper[board[k][i] - '0']++;
            }
            if (isFalse(helper)) return false;
        }
        //squares
        for (int n : new int[]{0, 3, 6}) {
            for (int j : new int[]{0, 3, 6}) {
                for (int i = 0; i < board.length / 3; i++) {
                    for (int k = 0; k < board[0].length / 3; k++) {
                        if (board[i + n][k + j] != '.') helper[board[i + n][k + j] - '0']++;
                    }
                }
                if (isFalse(helper)) return false;
            }
        }
        return true;
    }

    private boolean isFalse(int[] helper) {
        for (int i = 0; i < helper.length; i++) {
            if (helper[i] > 1) return true;
            helper[i] = 0;
        }
        return false;
    }
}
