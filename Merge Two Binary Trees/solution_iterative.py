# https://leetcode.com/problems/merge-two-binary-trees
# 
# Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
# 
# You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
# 
# Example 1:
# Input: 
# 	Tree 1                     Tree 2                  
#           1                         2                             
#          / \                       / \                            
#         3   2                     1   3                        
#        /                           \   \                      
#       5                             4   7                  
# Output: 
# Merged tree:
# 	     3
# 	    / \
# 	   4   5
# 	  / \   \ 
# 	 5   4   7
# Note: The merging process must start from the root nodes of both trees.
# 
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def mergeTrees(self, t1, t2):
        """
        :type t1: TreeNode
        :type t2: TreeNode
        :rtype: TreeNode
        """
        if not t1:
            return t2
        if not t2:
            return t1
        head = TreeNode(0)
        d1, d2, master = [t1], [t2], [head]
        while d1 or d2:
            cm = master.pop(0)
            c1 = d1.pop(0)
            c2 = d2.pop(0)
            if not c1 and not c2:
                continue
            value1 = c1.val if c1 else 0
            value2 = c2.val if c2 else 0
            cm.val = value1 + value2
            if c1 and c1.left or c2 and c2.left:
                cm.left = TreeNode(0)
                master.append(cm.left)
                d1.append(c1.left if c1 else None)
                d2.append(c2.left if c2 else None)
            if c1 and c1.right or c2 and c2.right:
                cm.right = TreeNode(0)
                master.append(cm.right)
                d1.append(c1.right if c1 else None)
                d2.append(c2.right if c2 else None)
        return head
