// https://leetcode.com/problems/n-queens
// 
// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
// 
// 
// 
// Given an integer n, return all distinct solutions to the n-queens puzzle.
// 
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
// 
// For example,
// There exist two distinct solutions to the 4-queens puzzle:
// 
// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],
// 
//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]
class Solution {
    private boolean canPlaceQueen(boolean[][] matrix, int row, int column, int n) {
        for (int i = 0; i < row; i++) {
            if (matrix[i][column]) return false;
        }
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j]) return false;
        }
        for (int i = row, j = column; i >= 0 && j < n; i--, j++) {
            if (matrix[i][j]) return false;
        }
        return true;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(n);
        boolean[][] matrix = new boolean[n][n];
        dfs(0, matrix, result, n);
        return result;
    }

    private void dfs(int row, boolean[][] matrix, List<List<String>> result, int n) {
        if (row == n) {
            convertToAnswer(matrix, result, n);
        } else {
            for (int column = 0; column < n; column++) {
                if (canPlaceQueen(matrix, row, column, n)) {
                    matrix[row][column] = true;
                    dfs(row + 1, matrix, result, n);
                    matrix[row][column] = false;
                }
            }
        }
    }

    private void convertToAnswer(boolean[][] matrix, List<List<String>> result, int n) {
        List<String> helper = new ArrayList<>(n);
        for (boolean[] temp : matrix) {
            char[] chars = new char[n];
            int cursor = 0;
            for (boolean t : temp) {
                chars[cursor++] = t ? 'Q' : '.';
            }
            helper.add(new String(chars));
        }
        result.add(helper);
    }
}
