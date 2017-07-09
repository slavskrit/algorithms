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
