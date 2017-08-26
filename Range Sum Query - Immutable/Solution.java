// https://leetcode.com/problems/range-sum-query-immutable
// 
// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
// Example:
// 
// Given nums = [-2, 0, 3, -5, 2, -1]
// 
// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
// 
// 
// Note:
// 
// You may assume that the array does not change.
// There are many calls to sumRange function.
// 
// 
public class NumArray {
    
    private int summ = 0;
    private int[] array;

    public NumArray(int[] nums) {
        array = nums;
        for(int i: array) {
            summ += i;
        }
    }
    
    public int sumRange(int i, int j) {
        int result = summ;
        for(int l = 0; l < i; l++) {
            result -= array[l];
        }
        
        for(int r = array.length - 1; r > j; r--) {
            result -= array[r];
        }
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
