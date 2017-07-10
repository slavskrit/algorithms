public class Solution {
    public int findLHS(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer temp = map.get(i);
            if (temp == null) {
                map.put(i, 1);
            } else {
                map.put(i, temp + 1);
            }
        }
        for (int i : nums) {
            Integer t1 = map.get(i);
            Integer t2 = map.get(i + 1);
            if (t1 != null && t2 != null) result = Math.max(result, t1 + t2);
        }
        return result;
    }
}
