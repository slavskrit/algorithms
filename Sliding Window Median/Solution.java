// https://leetcode.com/problems/sliding-window-median
// 
// Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
// 
// Examples: 
// [2,3,4] , the median is 3
// 
// [2,3], the median is (2 + 3) / 2 = 2.5
// 
// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
// 
// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
// 
// Window position                Median
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       1
//  1 [3  -1  -3] 5  3  6  7       -1
//  1  3 [-1  -3  5] 3  6  7       -1
//  1  3  -1 [-3  5  3] 6  7       3
//  1  3  -1  -3 [5  3  6] 7       5
//  1  3  -1  -3  5 [3  6  7]      6
// Therefore, return the median sliding window as [1,-1,-1,3,5,6].
// 
// Note: 
// You may assume k is always valid, ie: k is always smaller than input array's size for non-empty array.
class Solution {
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        int cursor = 0;
        min = new PriorityQueue<>();
        max = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i >= k) {
                result[cursor++] = getMedian();
                remove(nums[j++]);
            }
            add(nums[i]);
        }
        result[cursor] = getMedian();
        return result;
    }

    private void add(int num) {
        (num < getMedian() ? max : min).offer(num);
        balance();
    }

    private void remove(int num) {
        (num < getMedian() ? max : min).remove(num);
        balance();
    }

    private void balance() {
        if (max.size() > min.size()) {
            min.offer(max.poll());
        }
        if (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }
    }

    private double getMedian() {
        if (max.isEmpty() && min.isEmpty()) return 0.0;
        double median = min.peek();
        if (min.size() == max.size()) {
            median = min.peek() / 2.0 + max.peek() / 2.0;
        }
        return median;
    }
}
