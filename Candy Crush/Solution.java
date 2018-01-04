// https://leetcode.com/problems/candy-crush
// 
// This question is about implementing a basic elimination algorithm for Candy Crush.
// 
// Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:
// 
// If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
// After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
// After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
// If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
// You need to perform the above rules until the board becomes stable, then return the current board.
// 
// Example 1:
// Input:
// board = 
// [[110,5,112,113,114],[210,211,5,213,214],[310,311,3,313,314],[410,411,412,5,414],[5,1,512,3,3],[610,4,1,613,614],[710,1,2,713,714],[810,1,2,1,1],[1,1,2,2,2],[4,1,4,4,1014]]
// Output:
// [[0,0,0,0,0],[0,0,0,0,0],[0,0,0,0,0],[110,0,0,0,114],[210,0,0,0,214],[310,0,0,113,314],[410,0,0,213,414],[610,211,112,313,614],[710,311,412,613,714],[810,411,512,713,1014]]
// Explanation: 
// 
// Note:
// The length of board will be in the range [3, 50].
// The length of board[i] will be in the range [3, 50].
// Each board[i][j] will initially start as an integer in the range [1, 2000].
class Solution {
    private int[][] board;
    private int width;
    private int heigth;
    private Queue<int[]> queue;
    private final static int MIN = 3;
    private final static int EMPTY = 0;
    private final static int TO_DELETE = -1;

    private void addToQueue(int temp, int i, int j, boolean isVertical) {
        if (isVertical) {
            while (temp-- > 0) {
                queue.add(new int[]{i + temp, j});
            }
        } else {
            while (temp > 0) {
                queue.add(new int[]{i, j - temp});
                temp--;
            }
        }
    }

    private void checkHorizontal() {
        for (int i = 0; i < heigth; i++) {
            int temp = 1;
            for (int j = 1; j < width; j++) {
                if (board[i][j] == board[i][j - 1] && board[i][j] != EMPTY) {
                    temp++;
                } else {
                    if (temp >= MIN) addToQueue(temp, i, j, false);
                    temp = 1;
                }
            }
            if (temp >= MIN) addToQueue(temp, i, width, false);
        }
    }

    private void checkVertical() {
        for (int i = 0; i < width; i++) {
            int temp = 1;
            for (int j = heigth - 1; j > 0 && board[j][i] != 0; j--) {
                if (board[j][i] == board[j - 1][i] && board[j][i] != EMPTY) {
                    temp++;
                } else {
                    if (temp >= MIN) addToQueue(temp, j, i, true);
                    temp = 1;
                }
            }
            if (temp >= MIN) addToQueue(temp, 0, i, true);
        }
    }

    private void findCells() {
        checkHorizontal();
        checkVertical();
    }

    private void moveDown() {
        for (int i = 0; i < width; i++) {
            int slow = heigth - 1;
            for (int j = heigth - 1; j >= 0 && board[j][i] != EMPTY; j--) {
                if (board[j][i] != TO_DELETE) {
                    board[slow][i] = board[j][i];
                    slow--;
                }
            }
            while (slow >= 0) {
                board[slow--][i] = EMPTY;
            }
        }
    }

    private void deleteCells() {
        while (!queue.isEmpty()) {
            board[queue.peek()[0]][queue.poll()[1]] = TO_DELETE;
        }
    }

    public int[][] candyCrush(int[][] board) {
        this.board = board;
        this.heigth = board.length;
        this.width = board[0].length;
        this.queue = new LinkedList<>();
        findCells();
        while (!queue.isEmpty()) {
            deleteCells();
            moveDown();
            findCells();
        }
        return board;
    }
}
