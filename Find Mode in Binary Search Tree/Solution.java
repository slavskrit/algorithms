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
