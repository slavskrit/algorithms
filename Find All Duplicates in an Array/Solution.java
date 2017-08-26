// https://leetcode.com/problems/find-all-duplicates-in-an-array
// 
// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
// Find all the elements that appear twice in this array.
// Could you do it without extra space and in O(n) runtime?
// 
// Example:
// 
// Input:
// [4,3,2,7,8,2,3,1]
// 
// Output:
// [2,3]
// 
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[nums.length + 1];
        for(int i: nums) {
            temp[i]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 2) result.add(i);
        }
        return result;
    }
}
