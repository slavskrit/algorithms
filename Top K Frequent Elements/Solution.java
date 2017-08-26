// https://leetcode.com/problems/top-k-frequent-elements
// 
// 
// Given a non-empty array of integers, return the k most frequent elements.
// For example,
// Given [1,1,1,2,2,3] and k = 2, return [1,2].
// 
// Note: 
// 
// You may assume k is always valid, 1 ? k ? number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
// 
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
