// https://leetcode.com/problems/binary-search-tree-iterator
// 
// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
// Calling next() will return the next smallest number in the BST.
// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
// Credits:Special thanks to @ts for adding this problem and creating all test cases.
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
