// https://leetcode.com/problems/find-k-pairs-with-smallest-sums
// 
// 
// You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k. 
// 
// Define a pair (u,v) which consists of one element from the first array and one element from the second array.
// Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
// 
// Example 1:
// 
// Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3
// 
// Return: [1,2],[1,4],[1,6]
// 
// The first 3 pairs are returned from the sequence:
// [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
// 
// Example 2:
// 
// Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2
// 
// Return: [1,1],[1,1]
// 
// The first 2 pairs are returned from the sequence:
// [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
// 
// Example 3:
// 
// Given nums1 = [1,2], nums2 = [3],  k = 3 
// 
// Return: [1,3],[2,3]
// 
// All possible pairs are returned from the sequence:
// [1,3],[2,3]
// 
// 
// Credits:Special thanks to @elmirap and @StefanPochmann for adding this problem and creating all test cases.
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
