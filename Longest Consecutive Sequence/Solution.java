class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) continue;
            int l = map.getOrDefault(i - 1, 0);
            int r = map.getOrDefault(i + 1, 0);
            int temp = l + r + 1; // at least 1 consecutive digit is current digit itself
            map.put(i, temp);
            map.put(i - l, temp);
            map.put(i + r, temp);
            result = Math.max(result, temp);
        }
        return result;
    }
}
