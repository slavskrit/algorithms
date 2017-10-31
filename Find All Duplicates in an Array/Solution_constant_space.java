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
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                int next = nums[i];
                nums[i] = -nums[i];
                while (next > 0) {
                    if (nums[next - 1] == 0) {
                        result.add(next);
                    }
                    int temp = nums[next - 1];
                    nums[next - 1] = 0;
                    next = temp;
                }
            }
        }
        return result;
    }
}
