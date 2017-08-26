// https://leetcode.com/problems/minimum-depth-of-binary-tree
// 
// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int a = minDepth(root.left);
        int b = minDepth(root.right);
        if (a == 0 || b == 0) {
            return a + b + 1;
        } else {
            return Math.min(a, b) + 1;
        }
    }
}
