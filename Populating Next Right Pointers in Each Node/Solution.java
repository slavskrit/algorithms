// https://leetcode.com/problems/populating-next-right-pointers-in-each-node
// 
// 
// Given a binary tree
// 
//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// 
// 
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
// Initially, all next pointers are set to NULL.
// 
// Note:
// 
// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// 
// 
// 
// For example,
// Given the following perfect binary tree,
// 
//          1
//        /  \
//       2    3
//      / \  / \
//     4  5  6  7
// 
// 
// 
// After calling your function, the tree should look like:
// 
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL
// 
// 
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
