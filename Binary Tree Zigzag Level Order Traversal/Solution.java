// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal
// 
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
// 
// For example:
// Given binary tree [3,9,20,null,null,15,7],
// 
//     3
//    / \
//   9  20
//     /  \
//    15   7
// 
// 
// 
// return its zigzag level order traversal as:
// 
// [
//   [3],
//   [20,9],
//   [15,7]
// ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean direction = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            while (size-- > 0) {
                TreeNode current = queue.poll();
                if (direction) {
                    temp.add(current.val);
                } else {
                    temp.add(0, current.val);
                }
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            direction = !direction;
            result.add(temp);
        }
        return result;
    }
}
