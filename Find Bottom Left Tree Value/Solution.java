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

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int result = root.val;
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean firstInRow = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (!firstInRow) {
                    result = t.val;
                    firstInRow = true;
                }
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
        }
        return result;

    }
}
