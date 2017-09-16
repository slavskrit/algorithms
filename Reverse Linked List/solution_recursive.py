# Reverse a singly linked list.
# 
# 
# Hint:
# A linked list can be reversed either iteratively or recursively. Could you implement both?
# 
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if not head or not head.next:
            return head
        temp = head.next
        new = self.reverseList(temp)
        temp.next = head
        head.next = None
        return new
