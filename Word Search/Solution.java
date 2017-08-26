// https://leetcode.com/problems/word-search
// 
// 
// Given a 2D board and a word, find if the word exists in the grid.
// 
// 
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
// 
// 
// For example,
// Given board = 
// 
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
// 
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
// 
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        int m = board.length;
        int n = board[0].length;
        char[] w = word.toCharArray();
        for (int mm = 0; mm < m; mm++) {
            for (int nn = 0; nn < n; nn++) {
                if (backtrack(board, w, 0, mm, nn, m, n)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] w, int cursor, int y, int x, int m, int n) {
        if (cursor == w.length) return true;
        if (y < 0 || y >= m || x < 0 || x >= n) return false;
        if (board[y][x] != w[cursor]) return false;
        board[y][x] += 'a';
        boolean exist = backtrack(board, w, cursor + 1, y + 1, x, m, n) ||
                backtrack(board, w, cursor + 1, y - 1, x, m, n) ||
                backtrack(board, w, cursor + 1, y, x + 1, m, n) ||
                backtrack(board, w, cursor + 1, y, x - 1, m, n);
        board[y][x] -= 'a';
        return exist;
    }
}
