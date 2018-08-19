// https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
// 
// Given an n-ary tree, return the preorder traversal of its nodes' values.
// 
//  
// For example, given a 3-ary tree:
// 
// 
// 
//  
// Return its preorder traversal as: [1,3,5,6,2,4].
// 
//  
// Note: Recursive solution is trivial, could you do it iteratively?
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root == null) return result;
        deque.push(root);
        while(!deque.isEmpty()) {
            Node current = deque.pop();
            result.add(current.val);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                deque.push(current.children.get(i));
            }
        }
        return result;
    }
}
