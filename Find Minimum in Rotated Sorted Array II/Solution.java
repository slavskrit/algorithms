public class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
            else {
                right--;
            }
        }
        return nums[left];
    }
}
