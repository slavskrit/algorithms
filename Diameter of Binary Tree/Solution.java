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
    int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        recursion(root);
        return result;
    }

    private int recursion(TreeNode root) {
        if (root == null) return 0;
        else {
            int left = recursion(root.left);
            int right = recursion(root.right);
            result = Math.max(result, left + right);
            return Math.max(left, right) + 1;
        }
    }
}
