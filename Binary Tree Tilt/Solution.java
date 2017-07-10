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
    
    private int tilt = 0;
    
    public int findTilt(TreeNode root) {
        helper(root);
        return tilt;
    }
    
    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        tilt += Math.abs(right - left);
        return left + right + root.val;
    }
    
}
