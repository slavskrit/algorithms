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
    Queue<TreeNode> queue = new LinkedList<>();

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode current = root;
        helper(root.left);
        helper(root.right);
        root.left = null;
        while (!queue.isEmpty()) {
            current.right = queue.poll();
            current.right.left = null;
            current = current.right;
        }
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        queue.offer(root);
        helper(root.left);
        helper(root.right);
    }
}
