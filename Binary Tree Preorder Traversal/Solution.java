// https://leetcode.com/problems/binary-tree-preorder-traversal
// 
// Given a binary tree, return the preorder traversal of its nodes' values.
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
// return [1,2,3].
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        recursion(root, result);   
        return result;
    }

    private void recursion(TreeNode root, List<Integer> result) {
        if (root == null) return;
        result.add(root.val);
        recursion(root.left, result);
        recursion(root.right, result);
    }
}
