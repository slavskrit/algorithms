// https://leetcode.com/problems/find-mode-in-binary-search-tree
// 
// Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
// 
// Assume a BST is defined as follows:
// 
// The left subtree of a node contains only nodes with keys less than or equal to the node's key.
// The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
// Both the left and right subtrees must also be binary search trees.
// 
// 
// 
// For example:
// Given BST [1,null,2,2],
// 
//    1
//     \
//      2
//     /
//    2
// 
// 
// 
// return [2].
// 
// Note:
// If a tree has more than one mode, you can return them in any order.
// 
// Follow up:
// Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
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
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        map = calculateMap(root, map);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    private static HashMap<Integer, Integer> calculateMap(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return null;
        Integer a = map.get(root.val);
        if (a == null) {
            map.put(root.val, 1);
        } else {
            map.put(root.val, a + 1);
        }
        calculateMap(root.left, map);
        calculateMap(root.right, map);
        return map;
    }
    
}
