// https://leetcode.com/problems/path-sum-ii
// 
// 
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
// 
// 
// For example:
// Given the below binary tree and sum = 22,
// 
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// 
// 
// return
// 
// [
//    [5,4,11,2],
//    [5,8,4,5]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, new ArrayList<>(), sum, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> stack,int sum, List<List<Integer>> result) {
        if (root == null) return;
        sum -= root.val;
        stack.add(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            result.add(new ArrayList<>(stack));
        } else {
            dfs(root.left, stack, sum, result);
            dfs(root.right, stack, sum, result);
        }
        stack.remove(stack.size() - 1);
    }
}
