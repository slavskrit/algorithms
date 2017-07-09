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
    boolean isValid = true;

    public boolean isValidBST(TreeNode root) {
        recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return isValid;
    }

    private void recursion(TreeNode root, long min, long max) {
        if (root == null) {
            return;
        }
        if (root.val <= min || root.val >= max) {
            isValid = false;
            return;
        }
        recursion(root.left, min, root.val);
        recursion(root.right, root.val, max);
    }
}
