/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Deque<TreeNode> deque = new LinkedList<>();

    public BSTIterator(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            deque.push(current);
            current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = deque.poll();
        TreeNode right = temp.right;
        if (right != null) {
            deque.push(right);
            TreeNode left = right.left;
            while (left != null) {
                deque.push(left);
                left = left.left;
            }
        }
        return temp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
