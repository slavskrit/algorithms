// https://leetcode.com/problems/merge-sorted-array
// 
// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
// 
// Note:
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int[] helper = new int[m];
        for (int i = 0; i < m; i++) {
            helper[i] = nums1[i];
        }

        int cursor1 = 0;
        int cursor2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (cursor2 < n) {
                if (cursor1 < helper.length && helper[cursor1] < nums2[cursor2]) {
                    nums1[i] = helper[cursor1];
                    cursor1++;
                } else {
                    nums1[i] = nums2[cursor2];
                    cursor2++;
                }
            } else {
                nums1[i] = helper[cursor1];
                cursor1++;
            }
        }
    }
}
