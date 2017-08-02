public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                int key = i + j;
                map.merge(key, 1, (a, b) -> a + b);
            }
        }
        for (int i : C) {
            for (int j : D) {
                int key = i + j;
                Integer increaser = map.get(-key);
                result += increaser == null ? 0 : increaser;
            }
        }
        return result;
    }
}
