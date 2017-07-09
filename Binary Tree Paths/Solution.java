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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(result, root, String.valueOf(root.val));
        return result;
    }

    private void dfs(List<String> result, TreeNode current, String path) {
        if (current.left == null && current.right == null) {
            result.add(path);
        } else {
            if (current.left != null) dfs(result, current.left, path + "->" + current.left.val);
            if (current.right != null) dfs(result, current.right, path + "->" + current.right.val);
        }
    }
}
