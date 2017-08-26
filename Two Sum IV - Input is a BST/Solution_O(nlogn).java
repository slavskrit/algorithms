// https://leetcode.com/problems/two-sum-iv-input-is-a-bst
//
// Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
// Example 1:
//
// Input:
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7
//
// Target = 9
//
// Output: True
//
//
// Example 2:
//
// Input:
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7
//
// Target = 28
//
// Output: False
//
//
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
    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            TreeNode temp = deque.poll();
            if (temp.left != null) deque.push(temp.left);
            if (temp.right != null) deque.push(temp.right);
            int toFind = k - temp.val;
            TreeNode cursor = root;
            while (cursor != null && temp != cursor) {
                if (cursor.val == toFind) {
                    return true;
                } else if (cursor.val > toFind) {
                    cursor = cursor.left;
                } else {
                    cursor = cursor.right;
                }
            }
        }
        return false;   
    }
}
