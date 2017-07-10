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
