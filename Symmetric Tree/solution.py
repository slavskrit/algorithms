# https://leetcode.com/problems/symmetric-tree
# 
# Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
# 
# For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
# 
#     1
#    / \
#   2   2
#  / \ / \
# 3  4 4  3
# 
# 
# 
# But the following [1,2,2,null,3,null,3]  is not:
# 
#     1
#    / \
#   2   2
#    \   \
#    3    3
# 
# 
# 
# Note:
# Bonus points if you could solve it both recursively and iteratively.
# 
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSymmetric(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root: return True
        level = [root.left, root.right]
        while level:
            left = level.pop(0)
            right = level.pop()
            if not left and not right:
                continue
            if not left and right or left and not right or left.val != right.val:
                return False
            level.insert(0, left.right)
            level.insert(0, left.left)
            level.append(right.left)
            level.append(right.right)
        return True
