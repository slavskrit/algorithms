// https://leetcode.com/problems/task-scheduler
// 
// Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
// 
// However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
// 
// You need to return the least number of intervals the CPU will take to finish all the given tasks.
// 
// Example 1:
// Input: tasks = ["A","A","A","B","B","B"], n = 2
// Output: 8
// Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
// Note:
// The number of tasks is in the range [1, 10000].
// The integer n is in the range [0, 100].
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> (o2.getValue() - o1.getValue())
        );
        Queue<Map.Entry<Character, Integer>> wait = new LinkedList<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            int temp = n + 1;
            while (temp > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> current = pq.poll();
                current.setValue(current.getValue() - 1);
                if (current.getValue() > 0) wait.offer(current);
                temp--;
                result++;
            }
            pq.addAll(wait);
            wait.clear();
            if (pq.isEmpty()) break;
            result += temp;
        }
        return result;
    }
}
