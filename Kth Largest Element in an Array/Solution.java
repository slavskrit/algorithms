// https://leetcode.com/problems/kth-largest-element-in-an-array
// 
// Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
// 
// For example,
// Given [3,2,1,5,6,4] and k = 2, return 5.
// 
// Note: 
// You may assume k is always valid, 1 ? k ? array's length.
// Credits:Special thanks to @mithmatt for adding this problem and creating all test cases.
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i : nums) queue.add(i);
        while (k-- > 1) queue.poll();
        return queue.poll();   
    }
}
