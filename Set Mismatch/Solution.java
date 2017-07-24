public class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int first = 0;
        int second = 0;
        int max = Integer.MIN_VALUE;
        if (nums.length == 0) return new int[]{first, second};
        for (int i : nums) {
            max = Math.max(max, i);
            if (!set.add(i)) {
                first = i;
            }
        }
        for (int i = 1; i <= max + 1; i++) {
            if (!set.contains(i)) {
                second = i;
                break;
            }
        }
        return new int[]{first, second};
    }
}
