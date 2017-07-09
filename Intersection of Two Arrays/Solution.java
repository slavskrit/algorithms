public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        ArrayList<Integer> array = new ArrayList<>();
        for (int c: nums1) {
            set1.add(c);
        }
        for (int c: nums2) {
            if (set1.contains(c) && !array.contains(c)) array.add(c);
        }
        int[] result = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            result[i] = array.get(i);
        }
        return result;
    }
}
