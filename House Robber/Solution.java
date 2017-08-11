public class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        if (length == 1) return nums[0];
        if (length == 2) return Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            nums[i] = Math.max(nums[i - 2] + nums[i], nums[i - 1]);
            nums[i - 1] = Math.max(nums[i - 1], nums[i - 2]);
        }
        return Math.max(nums[length - 1], nums[length - 2]);
    }
}
