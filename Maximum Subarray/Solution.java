public class Solution {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int result = Integer.MIN_VALUE;
        int helper = Integer.MIN_VALUE;
        int temp = 0;
        for (int i : nums) {
            helper = Math.max(helper, i);
            result = Math.max(result, temp);
            if (temp + i < 0) {
                temp = 0;
            } else {
                temp += i;
            }
        }
        int max = Math.max(result, temp);
        return max == 0 ? helper : Math.max(result, temp);
    }
}
