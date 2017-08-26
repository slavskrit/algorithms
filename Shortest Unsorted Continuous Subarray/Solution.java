// https://leetcode.com/problems/shortest-unsorted-continuous-subarray
// 
// Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too. 
// You need to find the shortest such subarray and output its length.
// Example 1:
// 
// Input: [2, 6, 4, 8, 10, 9, 15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
// 
// 
// Note:
// 
// Then length of the input array is in range [1, 10,000].
// The input array may contain duplicates, so ascending order here means <=. 
// 
// 
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int f = 0;
        int s = length - 1;
        if (temp[0] != nums[0] && temp[length - 1] != nums[length - 1]) return length;
        for (int i = f; i < length; i++) {
            if (nums[i] != temp[i]) {
                f = i;
                break;
            }
        }
        for (int i = s; i >= 0; i--) {
            if (nums[i] != temp[i]) {
                s = i;
                break;
            }
        }
        if (f == 0 && s == length - 1) return 0;
        return s - f + 1;
    }
}
