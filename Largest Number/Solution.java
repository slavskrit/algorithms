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
