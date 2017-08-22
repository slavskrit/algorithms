/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return helper(root, 1, 0, new ArrayList<>());
    }

    private int helper(TreeNode root, int deviation, int level, List<Integer> list) {
        if (root == null) return 0;
        if (list.size() <= level) list.add(deviation);
        int left = helper(root.left, deviation * 2, level + 1, list);
        int right = helper(root.right, deviation * 2 + 1, level + 1, list);
        return Math.max(deviation - list.get(level) + 1, Math.max(left, right));
    }
}
