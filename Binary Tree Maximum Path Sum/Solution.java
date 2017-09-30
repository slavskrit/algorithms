// https://leetcode.com/problems/binary-tree-maximum-path-sum
// 
// Given a binary tree, find the maximum path sum.
// 
// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
// 
// For example:
// Given the below binary tree,
// 
//        1
//       / \
//      2   3
// Return 6.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        Map<TreeNode, Integer> map = new HashMap<>();
        helper(root, map);
        return max;
    }

    private void helper(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) return;
        helper(root.left, map);
        helper(root.right, map);
        int left = map.getOrDefault(root.left, 0);
        int right = map.getOrDefault(root.right, 0);
        int temp = Math.max(root.val + left, Math.max(root.val + right, root.val));
        map.put(root, temp);
        max = Math.max(temp, Math.max(max, right + left + root.val));
    }
}
