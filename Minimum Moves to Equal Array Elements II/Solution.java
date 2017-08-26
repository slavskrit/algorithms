// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii
// 
// Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
// You may assume the array's length is at most 10,000.
// Example:
// 
// Input:
// [1,2,3]
// 
// Output:
// 2
// 
// Explanation:
// Only two moves are needed (remember each move increments or decrements one element):
// 
// [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
// 
// 
public class Solution {
    public int minMoves2(int[] nums) {
        int medium;
        int summ = 0;
        int moves = 0;
        Arrays.sort(nums);
        int middle = nums.length/2;
        if (nums.length%2 == 1) {
            medium = nums[middle];
        } else {
            medium = (nums[middle-1] + nums[middle]) / 2;
        }
        System.out.println(medium);
        for (int i = 0; i < nums.length; i++) {

            moves += Math.abs(nums[i] - medium);
        }
        return moves;
    }
}
