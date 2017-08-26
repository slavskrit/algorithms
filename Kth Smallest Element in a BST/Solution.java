// https://leetcode.com/problems/kth-smallest-element-in-a-bst
// 
// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
// Note: 
// You may assume k is always valid, 1 ? k ? BST's total elements.
// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
// Credits:Special thanks to @ts for adding this problem and creating all test cases.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    Integer result, counter = null;

    public int kthSmallest(TreeNode root, int k) {
        counter = k;
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root == null || result != null) return;
        helper(root.left);
        if (--counter == 0) result = root.val;
        helper(root.right);
    }
}
