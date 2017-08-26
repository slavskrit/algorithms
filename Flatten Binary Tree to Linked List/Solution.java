// https://leetcode.com/problems/flatten-binary-tree-to-linked-list
// 
// 
// Given a binary tree, flatten it to a linked list in-place.
// 
// 
// For example,
// Given
// 
//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// 
// 
// 
// The flattened tree should look like:
// 
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
// 
// click to show hints.
// Hints:
// If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
// 
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
    Queue<TreeNode> queue = new LinkedList<>();

    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode current = root;
        helper(root.left);
        helper(root.right);
        root.left = null;
        while (!queue.isEmpty()) {
            current.right = queue.poll();
            current.right.left = null;
            current = current.right;
        }
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        queue.offer(root);
        helper(root.left);
        helper(root.right);
    }
}
