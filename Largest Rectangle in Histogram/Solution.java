// https://leetcode.com/problems/largest-rectangle-in-histogram
// 
// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
// 
// 
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
// 
// 
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
// 
// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.
class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= heights.length; i++) {
            int h = i == heights.length ? 0 : heights[i];
            if (deque.isEmpty() || h > heights[deque.peek()]) {
                deque.push(i);
            } else {
                int height = heights[deque.pop()];
                int width = deque.isEmpty() ? i : i - deque.peek() - 1;
                result = Math.max(result, height * width);
                i--;
            }
        }
        return result;
    }
}
