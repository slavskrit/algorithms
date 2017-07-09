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
    int sum = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        this.sum = sum;
        helper(root);
        return result;
    }

    private void helper(TreeNode current) {
        calculate(current, 0);
        if (current.left != null) helper(current.left);
        if (current.right != null) helper(current.right);
    }

    private void calculate(TreeNode current, int currentSumm) {
        if (current == null) return;
        currentSumm += current.val;
        if (currentSumm == sum) result++;
        calculate(current.left, currentSumm);
        calculate(current.right, currentSumm);
    }
}
