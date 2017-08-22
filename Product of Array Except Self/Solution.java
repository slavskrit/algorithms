class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        if (length == 0) return nums;
        int[] result = new int[length];
        int temp = 1;
        for (int i = 0; i < length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        temp = 1;
        for (int i = length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}
