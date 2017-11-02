"""
https://leetcode.com/problems/copy-list-with-random-pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
"""
# Definition for singly-linked list with a random pointer.
# class RandomListNode(object):
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution(object):
    def copyRandomList(self, head):
        """
        :type head: RandomListNode
        :rtype: RandomListNode
        """
        cursor = head
        d = {}
        while cursor:
            d[cursor] = RandomListNode(cursor.label)
            cursor = cursor.next
        cursor = head
        while cursor:
            d.get(cursor).next = d.get(cursor.next)
            d.get(cursor).random = d.get(cursor.random)
            cursor = cursor.next
        return d.get(head)
