// https://leetcode.com/problems/binary-tree-vertical-order-traversal
// Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
// 
// If two nodes are in the same row and column, the order should be from left to right.
// 
// Examples:
// 
// Given binary tree [3,9,20,null,null,15,7],
//    3
//   /\
//  /  \
//  9  20
//     /\
//    /  \
//   15   7
// return its vertical order traversal as:
// [
//   [9],
//   [3,15],
//   [20],
//   [7]
// ]
// Given binary tree [3,9,8,4,0,1,7],
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
// return its vertical order traversal as:
// [
//   [4],
//   [9],
//   [3,0,1],
//   [8],
//   [7]
// ]
// Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
//      3
//     /\
//    /  \
//    9   8
//   /\  /\
//  /  \/  \
//  4  01   7
//     /\
//    /  \
//    5   2
// return its vertical order traversal as:
// [
//   [4],
//   [9,5],
//   [3,0,1],
//   [8,2],
//   [7]
// ]
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, map, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> t : map.values()) {
            t.sort(Comparator.comparingInt(o -> o[0]));
            List<Integer> temp = new ArrayList<>();
            for (int[] r : t) temp.add(r[1]);
            result.add(temp);
        }
        return result;
    }

    private void dfs(TreeNode root, Map<Integer, List<int[]>> map, int i, int level) {
        if (root == null) return;
        List<int[]> temp = map.get(i);
        if (temp == null) {
            temp = new ArrayList<>();
        }
        temp.add(new int[] {level, root.val});
        map.put(i, temp);
        dfs(root.left, map, i - 1, level + 1);
        dfs(root.right, map, i + 1, level + 1);
    }
}
