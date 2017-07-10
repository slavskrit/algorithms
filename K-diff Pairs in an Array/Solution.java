public class Solution {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) result++;
            } else {
                if (map.containsKey(entry.getKey() + k)) result++;
            }
        }
        return result;
    }
}
