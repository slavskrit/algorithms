// https://leetcode.com/problems/find-k-closest-elements
// 
// Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
// 
// Example 1:
// Input: [1,2,3,4,5], k=4, x=3
// Output: [1,2,3,4]
// Example 2:
// Input: [1,2,3,4,5], k=4, x=-1
// Output: [1,2,3,4]
// Note:
// The value k is positive and will always be smaller than the length of the sorted array.
// Length of the given array is positive and will not exceed 104
// Absolute value of elements in the array and x will not exceed 104
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int length = arr.length;
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) result.add(arr[i]);
        } else if (x > arr[length - 1]) {
            for (int i = length - k; i < length; i++) result.add(arr[i]);
        } else {
            int left = 0;
            int right = length - k;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (x - arr[mid] > arr[mid + k] - x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int cursor = left;
            while (cursor < left + k) result.add(arr[cursor++]);
        }
        return result;
    }
}
