public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            Integer t = map.get(i);
            if (t == null) {
                map.put(i, 1);
            } else {
                map.put(i, t + 1);
            }
        }
        List<Integer> nums = new ArrayList<>();
        for(int i : nums2) {
            Integer t = map.get(i);
            if(t != null && t > 0) {
                nums.add(i);
                map.put(i, t - 1);
            }
        }
        int[] result = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++) {
            result[i] = nums.get(i);
        }
        return result;
    }
}
