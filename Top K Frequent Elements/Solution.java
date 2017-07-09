import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums) {
            Integer t = map.get(i);
            if (t != null) {
                map.put(i, t + 1);
            } else {
                map.put(i, 1);
            }
        }
        PriorityQueue<AbstractMap.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<AbstractMap.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            queue.add(entry);
        }
        while (k-- > 0) {
            result.add(queue.poll().getKey());
        }
        return result;
    }
}
