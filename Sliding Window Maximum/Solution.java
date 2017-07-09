public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        if (k == 1) return nums;
        if (nums.length == k) {
            int[] array = new int[1];
            int max = nums[0];
            for (int i = 0; i < nums.length; i++) {
                if (max < nums[i]) max = nums[i];
            }
            array[0] = max;
            return array;
        }
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int right = k - 1;
        while (right < nums.length) {
            int max = nums[left];
            for (int i = left; i <= right; i++) {
                if (nums[i] > max) max = nums[i];
            }
            result.add(max);
            left++;
            right++;
        }
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;   
    }
}
