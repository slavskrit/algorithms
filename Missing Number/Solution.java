// https://leetcode.com/problems/missing-number
// 
// 
// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
// 
// For example,
// Given nums = [0, 1, 3] return 2.
// 
// 
// Note:
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
// 
// Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
public class Solution {

    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for(int i = 0; i < nums.length; i++) {
            xor ^= nums[i] ^ i;
        }
        return xor;
    }
}
