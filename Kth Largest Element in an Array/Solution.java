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
