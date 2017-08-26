// https://leetcode.com/problems/serialize-and-deserialize-binary-tree
//
// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
//
// For example, you may serialize the following tree
//
//     1
//    / \
//   2   3
//      / \
//     4   5
//
// as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
//
//
// Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
//
// Credits:Special thanks to @Louis1992 for adding this problem and creating all test cases.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private final static String DELIMETER = ",";
    private final static String NULL = "null";

    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append(NULL);
                sb.append(DELIMETER);
                continue;
            }
            sb.append(current.val);
            sb.append(DELIMETER);
            queue.offer(current.left);
            queue.offer(current.right);
        }
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (Character.isDigit(sb.charAt(i))) {
                return "[" + sb.substring(0, i + 1) + "]";
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        data = data.substring(1, data.length() - 1);
        String[] values = data.split(DELIMETER);
        if (values[0].equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode parent = queue.poll();
            if (!values[i].equals(NULL)) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }
            if (i < values.length - 1 && !values[++i].equals(NULL)) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
