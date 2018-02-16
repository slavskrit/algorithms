// 
// 
// Print a binary tree in an m*n 2D string array following these rules:
// 
// The row number m should be equal to the height of the given binary tree.
// The column number n should always be an odd number.
// The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
// Each unused space should contain an empty string "".
// Print the subtrees following the same rules.
// Example 1:
// Input:
//      1
//     /
//    2
// Output:
// [["", "1", ""],
//  ["2", "", ""]]
// Example 2:
// Input:
//      1
//     / \
//    2   3
//     \
//      4
// Output:
// [["", "", "", "1", "", "", ""],
//  ["", "2", "", "", "", "3", ""],
//  ["", "", "4", "", "", "", ""]]
// Example 3:
// Input:
//       1
//      / \
//     2   5
//    / 
//   3 
//  / 
// 4 
// Output:
// 
// [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
//  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
//  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
//  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// Note: The height of binary tree is in the range of [1, 10].
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
    private int getHeigth (TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeigth(root.left), getHeigth(root.right));
    }

    public List<List<String>> printTree(TreeNode root) {
        int heigth = getHeigth(root);
        int width = (int) Math.pow(2, heigth) - 1;
        String[][] helper = new String[heigth][width];
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                helper[i][j] = "";
            }
        }
        dfs(helper, root, 0, heigth, 0, width - 1);
        List<List<String>> result = new ArrayList<>();
        for (String[] temp : helper) {
            result.add(Arrays.asList(temp));
        }
        return result;
    }

    private void dfs(String[][] helper, TreeNode root, int row, int heigth, int left, int right) {
        if (root == null) return;
        int cursor = (left + right) / 2;
        helper[row][cursor] = String.valueOf(root.val);
        dfs(helper, root.left, row + 1, heigth, left, cursor - 1);
        dfs(helper, root.right, row + 1, heigth, cursor + 1, right);
    }
}
