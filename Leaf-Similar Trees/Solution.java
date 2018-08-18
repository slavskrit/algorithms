// https://leetcode.com/problems/leaf-similar-trees/description/
// 
// Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
// 
// 
// 
// For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
// 
// Two binary trees are considered leaf-similar if their leaf value sequence is the same.
// 
// Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
// 
//  
// 
// Note:
// 
// Both of the given trees will have between 1 and 100 nodes.
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        int[] f = new int[]{1};
        int[] s = new int[]{1};
        dfs(root1, f);
        dfs(root2, s);
        return f[0] == s[0];
    }

    private void dfs(TreeNode root, int[] h) {
        if (root.left == null && root.right == null) {
            h[0] = h[0] * 31 + root.val;
        }
        if (root.left != null) dfs(root.left, h);
        if (root.right != null) dfs(root.right, h);
    }
}
