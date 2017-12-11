// 
// 
// Given a binary tree where every node has a unique value, and a target key k, find the closest leaf node to target k in the tree.
// 
// A node is called a leaf if it has no children.
// 
// In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
// 
// Example 1:
// 
// Input:
// root = [1, 3, 2], k = 1
// Diagram of binary tree:
//           1
//          / \
//         3   2
// 
// Output: 2 (or 3)
// 
// Explanation: Either 2 or 3 is the closest leaf node to 1.
// Example 2:
// 
// Input:
// root = [1], k = 1
// Output: 1
// 
// Explanation: The closest leaf node is the root node itself.
// Example 3:
// 
// Input:
// root = [1,2,3,4,null,null,null,5,null,6], k = 2
// Diagram of binary tree:
//              1
//             / \
//            2   3
//           /
//          4
//         /
//        5
//       /
//      6
// 
// Output: 3
// Explanation: The leaf node with value 3 (and not the leaf node with value 6) is closest to the node with value 2.
// Note:
// root represents a binary tree with at least 1 node and at most 1000 nodes.
// Every node has a unique node.val in range [1, 1000].
// There exists some node in the given binary tree for which node.val == k.
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
    TreeNode node;

    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) return 0;
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        dfs(root, map, root, k);
        if (node != null) queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode temp = queue.poll();
                if (temp.left == null && temp.right == null) {
                    return temp.val;
                }
                if (visited.add(temp)) queue.addAll(map.get(temp));
            }
        }
        return -1;
    }

    private void dfs(TreeNode root, Map<TreeNode, List<TreeNode>> map, TreeNode parent, int k) {
        if (root.val == k) node = root;
        List<TreeNode> list = map.getOrDefault(root, new ArrayList<>());
        list.add(parent);
        if (root.left != null) {
            list.add(root.left);
            dfs(root.left, map, root, k);
        }
        if (root.right != null) {
            list.add(root.right);
            dfs(root.right, map, root, k);
        }
        map.put(root, list);
    }
}
