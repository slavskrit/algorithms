// https://leetcode.com/problems/find-duplicate-subtrees
// 
// 
// Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them. 
// 
// Two trees are duplicate if they have the same structure with same node values.
// 
// Example 1: 
// 
//         1
//        / \
//       2   3
//      /   / \
//     4   2   4
//        /
//       4
// 
// The following are two duplicate subtrees:
// 
//       2
//      /
//     4
// 
// and
// 
//     4
// 
// Therefore, you need to return above trees' root in the form of a list.
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
    Map<String, Boolean> map;
    List<TreeNode> result;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new ArrayList<>();
        if (root == null) return result;
        postorder(root);
        return result;
    }

    private String postorder(TreeNode root) {
        if (root == null) return "x";
        else {
            String temp = root.val + "," + postorder(root.left) + "," + postorder(root.right);
            if (map.containsKey(temp)) {
                if (map.get(temp)) {
                    map.put(temp, false);
                    result.add(root);
                }
            } else {
                map.put(temp, true);
            }
            return temp;
        }
    }
}
