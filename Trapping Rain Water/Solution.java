// https://leetcode.com/problems/trapping-rain-water
// 
// 
// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. 
// 
// 
// For example, 
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
// 
// 
// 
// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
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
