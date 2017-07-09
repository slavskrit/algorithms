public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int t = o1[0] + o1[1];
                int t1 = o2[0] + o2[1];
                if (t > t1) return 1;
                else return -1;
            }
        });
        for (int i : nums1) {
            for (int j : nums2) {
                int[] t = {i, j};
                heap.add(t);
            }
        }
        while (!heap.isEmpty()) {
            if (k-- == 0) break;
            result.add(heap.poll());
        }
        return result;
    }
}
