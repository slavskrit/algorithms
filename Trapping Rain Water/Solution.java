class Solution {
    public int trap(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            // Define tempLeft and tempRight to reduce accesses to array
            int tempLeft = height[left];
            int tempRight = height[right];
            if (tempLeft < tempRight) {
                leftMax = Math.max(leftMax, tempLeft);
                result += leftMax - tempLeft;
                left++;
            } else {
                rightMax = Math.max(rightMax, tempRight);
                result += rightMax - tempRight;
                right--;
            }
        }
        return result;
    }
}
