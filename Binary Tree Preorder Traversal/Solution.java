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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        recursion(root, result);   
        return result;
    }

    private void recursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        recursion(root.left, result);
        recursion(root.right, result);
    }
}
