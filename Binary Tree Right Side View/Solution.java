// https://leetcode.com/problems/binary-tree-right-side-view
// 
// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
// 
// For example:
// Given the following binary tree,
// 
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// 
// 
// 
// You should return [1, 3, 4].
// 
// Credits:Special thanks to @amrsaqr for adding this problem and creating all test cases.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                if (i == size - 1) result.add(t.val);
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
        }
        return result;
    }
}
