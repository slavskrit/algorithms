// https://leetcode.com/problems/binary-tree-postorder-traversal
// 
// Given a binary tree, return the postorder traversal of its nodes' values.
// 
// For example:
// Given binary tree {1,#,2,3},
// 
//    1
//     \
//      2
//     /
//    3
// 
// 
// 
// return [3,2,1].
// 
// Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.poll();
            result.add(0, temp.val);
            if (temp.left != null) deque.push(temp.left);
            if (temp.right != null) deque.push(temp.right);
        }
        return result;
    }
}
