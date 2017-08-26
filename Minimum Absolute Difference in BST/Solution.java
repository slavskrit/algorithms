// https://leetcode.com/problems/minimum-absolute-difference-in-bst
// 
// Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
// 
// Example:
// 
// Input:
// 
//    1
//     \
//      3
//     /
//    2
// 
// Output:
// 1
// 
// Explanation:
// The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
// 
// 
// Note:
// There are at least two nodes in this BST.
// 
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

   Integer min = Integer.MAX_VALUE;
    Integer helper;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        find(root);
        return min;
    }

    private void find(TreeNode root) {
        if (root == null) return;
        find(root.left);
        if (helper != null) min = Math.min(Math.abs(root.val - helper), min);
        helper = root.val;
        find(root.right);
    }

}
