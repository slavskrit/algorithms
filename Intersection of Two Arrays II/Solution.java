// https://leetcode.com/problems/intersection-of-two-arrays-ii
// 
// 
// Given two arrays, write a function to compute their intersection.
// 
// Example:
// Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
// 
// Note:
// 
// Each element in the result should appear as many times as it shows in both arrays.
// The result can be in any order.
// 
// 
// Follow up:
// 
// What if the given array is already sorted? How would you optimize your algorithm?
// What if nums1's size is small compared to nums2's size? Which algorithm is better?
// What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
// 
// 
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            Integer t = map.get(i);
            if (t == null) {
                map.put(i, 1);
            } else {
                map.put(i, t + 1);
            }
        }
        List<Integer> nums = new ArrayList<>();
        for(int i : nums2) {
            Integer t = map.get(i);
            if(t != null && t > 0) {
                nums.add(i);
                map.put(i, t - 1);
            }
        }
        int[] result = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            result[i] = nums.get(i);
        }
        return result;
    }
}
