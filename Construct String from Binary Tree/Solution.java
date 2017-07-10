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
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        helper(t, sb);
        return sb.subSequence(1, sb.length() - 1).toString();
    }

    private void helper(TreeNode t, StringBuilder sb) {
        sb.append("(");
        sb.append(t.val);
        if (t.left != null) helper(t.left, sb);
        if (t.right != null) {
            if (t.left == null) sb.append("()");
            helper(t.right, sb);
        }
        sb.append(")");
    }
}
