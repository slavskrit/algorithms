// https://leetcode.com/problems/find-largest-value-in-each-tree-row
// 
// You need to find the largest value in each row of a binary tree.
// Example:
// 
// Input: 
// 
//           1
//          / \
//         3   2
//        / \   \  
//       5   3   9 
// 
// Output: [1, 3, 9]
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = queue.peek().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                max = Math.max(temp.val, max);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right!= null) queue.add(temp.right);
            }
            result.add(max);
        }

        return result;
    }
}
