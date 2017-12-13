// https://leetcode.com/problems/majority-element-ii
// 
// Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int first = 0;
        int second = 1;
        int firstCount = 0;
        int secondCount = 0;
        for (int i : nums) {
            if (first == i) {
                firstCount++;
            } else if (second == i) {
                secondCount++;
            } else if (firstCount == 0) {
                first = i;
                firstCount++;
            } else if (secondCount == 0) {
                second = i;
                secondCount++;
            } else {
                firstCount--;
                secondCount--;
            }
        }
        firstCount = 0;
        secondCount = 0;
        for (int i : nums) {
            if (i == first) firstCount++;
            if (i == second) secondCount++;
        }
        if (firstCount * 3 > nums.length) result.add(first);
        if (secondCount * 3 > nums.length) result.add(second);
        return result;
    }
}
