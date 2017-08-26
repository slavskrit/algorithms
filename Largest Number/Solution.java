// https://leetcode.com/problems/largest-number
// 
// Given a list of non negative integers, arrange them such that they form the largest number.
// For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
// Note: The result may be very large, so you need to return a string instead of an integer.
// Credits:Special thanks to @ts for adding this problem and creating all test cases.
public class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder(nums.length);
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> {
            String a = o1 + o2;
            String b = o2 + o1;
            return a.compareTo(b);
        });
        for (int i : nums) {
            queue.offer(String.valueOf(i));
        }
        while (!queue.isEmpty()) {
            sb.insert(0, queue.poll());
        }
        int i = 0;
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }
}
