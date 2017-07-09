public class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int first = -1;
        int second = -1;
        if (length == 0) return new int[]{first, second};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                first = map.get(target - nums[i]);
                second = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{first, second};
    }
}
