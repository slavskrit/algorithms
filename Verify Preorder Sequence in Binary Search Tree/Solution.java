// https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree
// 
// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
// 
// You may assume each number in the sequence is unique.
// 
// Follow up:
// Could you do it using only constant space complexity?
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int prev = Integer.MIN_VALUE;
        Deque<Integer> deque = new LinkedList<>();
        for (int i : preorder) {
            if (i < prev) return false;
            while (!deque.isEmpty() && deque.peek() <= i) {
                prev = deque.pop();
            }
            deque.push(i);
        }
        return true;
    }
}
