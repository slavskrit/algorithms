// https://leetcode.com/problems/battleships-in-a-board
// 
// Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
// 
// 
// You receive a valid board, made of only battleships or empty slots.
// Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
// At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
// 
// Example:
// X..X
// ...X
// ...X
// 
// In the above board there are 2 battleships.
// 
// Invalid Example:
// ...X
// XXXX
// ...X
// 
// This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
// 
// Follow up:Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
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
