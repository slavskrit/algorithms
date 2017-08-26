// https://leetcode.com/problems/binary-tree-inorder-traversal
// 
// Given a binary tree, return the inorder traversal of its nodes' values.
// 
// For example:
// Given binary tree [1,null,2,3],
// 
//    1
//     \
//      2
//     /
//    3
// 
// 
// 
// return [1,3,2].
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        recursion(root, result);   
        return result;
    }

    private void recursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
        recursion(root.left, result);
        result.add(root.val);
        recursion(root.right, result);
    }
}
