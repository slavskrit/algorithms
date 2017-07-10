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
    TreeNode head;

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) return root;
        if (head == null) {
            d--;
            if (d == 0) {
                TreeNode newRoot = new TreeNode(v);
                newRoot.left = root;
                return newRoot;
            }
            head = root;
        }
        if (d == 1) {
            TreeNode left = new TreeNode(v);
            TreeNode right = new TreeNode(v);
            left.left = root.left;
            right.right = root.right;
            root.left = left;
            root.right = right;
        }
        addOneRow(root.left, v, d - 1);
        addOneRow(root.right, v, d - 1);
        return head;
    }
}
