// https://leetcode.com/problems/set-mismatch
// 
// 
// The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number. 
// 
// 
// Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
// 
// Example 1:
// 
// Input: nums = [1,2,2,4]
// Output: [2,3]
// 
// 
// Note:
// 
// The given array size will in the range [2, 10000].
// The given array's numbers won't have any order.
// 
// 
public class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int first = 0;
        int second = 0;
        int max = Integer.MIN_VALUE;
        if (nums.length == 0) return new int[]{first, second};
        for (int i : nums) {
            max = Math.max(max, i);
            if (!set.add(i)) {
                first = i;
            }
        }
        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) {
                second = i;
                break;
            }
        }
        return new int[]{first, second};
    }
}
