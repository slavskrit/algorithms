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
    Integer result = null;
    Integer counter;

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
