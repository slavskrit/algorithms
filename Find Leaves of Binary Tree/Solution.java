// https://leetcode.com/problems/find-leaves-of-binary-tree/description/
// 
// Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
// 
// Example:
// Given binary tree 
//           1
//          / \
//         2   3
//        / \     
//       4   5    
// Returns [4, 5, 3], [2], [1].
// 
// Explanation:
// 1. Removing the leaves [4, 5, 3] would result in this tree:
// 
//           1
//          / 
//         2          
// 2. Now removing the leaf [2] would result in this tree:
// 
//           1          
// 3. Now removing the leaf [1] would result in the empty tree:
// 
//           []         
// Returns [4, 5, 3], [2], [1].
// 
// Credits:
// Special thanks to @elmirap for adding this problem and creating all test cases.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        dfs(root, map);
        result.addAll(map.values());
        return result;
    }

    private int dfs(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) return 0;
        int left = dfs(root.left, map);
        int right = dfs(root.right, map);
        int level = Math.max(left, right) + 1;
        List<Integer> temp = map.get(level);
        if (temp == null) {
            temp = new ArrayList<>();
        }
        temp.add(root.val);
        map.put(level, temp);
        return level;
    }
}
