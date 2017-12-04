// https://leetcode.com/problems/daily-temperatures
// 
// Given a list of daily temperatures, produce a list that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
// 
// For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
// 
// Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && temperatures[deque.peek()] <= temperatures[i]) {
                deque.pop();
            }
            result[i] = deque.isEmpty() ? 0 : deque.peek() - i;
            deque.push(i);
        }
        return result;
    }
}
