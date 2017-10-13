// https://leetcode.com/problems/recover-binary-search-tree
// 
// Two elements of a binary search tree (BST) are swapped by mistake.
// 
// Recover the tree without changing its structure.
// 
// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev == null) {
            prev = root;
        } else {
            if (prev.val > root.val) {
                if (first == null) {
                    first = root;
                    second = prev;
                } else {
                    first = second;
                    second = root;
                }
            }
            prev = root;
        }
        dfs(root.right);
    }
}
