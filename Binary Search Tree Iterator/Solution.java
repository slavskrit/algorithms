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

    private void searchLeft(TreeNode current) {
        while (current != null) {
            deque.push(current);
            current = current.left;
        }
    }

    public BSTIterator(TreeNode root) {
        TreeNode current = root;
        searchLeft(current);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !deque.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = deque.poll();
        if (temp.right != null) {
            deque.push(temp.right);
            searchLeft(temp.right.left);
        }
        return temp.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
