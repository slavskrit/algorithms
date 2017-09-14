```
https://leetcode.com/problems/most-frequent-subtree-sum

Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
```
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def findFrequentTreeSum(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        sums, counts, helper = {}, {}, {}
        max_count = 0
        if root:
            first_stack = [root]
            second_stack = []
            while first_stack:
                current = first_stack.pop()
                second_stack.append(current)
                if current.left: first_stack.append(current.left)
                if current.right: first_stack.append(current.right)
            while second_stack:
                current = second_stack.pop()
                subtree_sum = sums.get(current.left, 0) + sums.get(current.right, 0) + current.val
                sums[current] = subtree_sum
                counts[subtree_sum] = counts.get(subtree_sum, 0) + 1
                max_count = max(max_count, counts[subtree_sum])
                if counts.get(subtree_sum) == max_count:
                    values = helper.get(max_count, [])
                    values.append(subtree_sum)
                    helper[max_count] = values
        return helper.get(max_count, [])
