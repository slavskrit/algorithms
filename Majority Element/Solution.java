// https://leetcode.com/problems/majority-element
// 
// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
// You may assume that the array is non-empty and the majority element always exist in the array.
// Credits:Special thanks to @ts for adding this problem and creating all test cases.
public class Solution {
    public int majorityElement(int[] nums) {
        int counter = 0, result = 0;
        for (int i : nums) {
            if (counter == 0) {
                result = i;
                counter++;
            }
            else if (i == result) counter++;
            else counter--;
        }
        return result;
    }
}
