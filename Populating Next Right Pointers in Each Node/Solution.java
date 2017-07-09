/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {

    TreeLinkNode parent;

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode t = queue.poll();
                if (i < size) {
                    if (parent == null) {
                        parent = t;
                    } else {
                        parent.next = t;
                        parent = parent.next;
                    }
                }
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
            parent = null;
        }
    }
}
