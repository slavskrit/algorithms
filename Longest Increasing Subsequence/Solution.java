public class Solution {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int[] dp = new int[length];
        int result = 1;
        for (int i = length - 1; i >= 0; i--) {
            int localMax = 0;
            // Find a greater int with max value
            for (int j = i; j < length; j++) {
                if (nums[i] < nums[j]) {
                    localMax = Math.max(localMax, dp[j]);
                }
            }
            dp[i] = localMax + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
