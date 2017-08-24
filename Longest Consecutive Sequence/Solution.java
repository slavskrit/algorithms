class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int search = i + 1;
                while (set.contains(search)) {
                    search++;
                }
                result = Math.max(result, search - i);
            }
        }
        return result;
    }
}
