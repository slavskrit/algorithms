// https://leetcode.com/problems/linked-list-cycle-ii
// 
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// 
// Note: Do not modify the linked list.
// 
// Follow up:
// Can you solve it without using extra space?
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != head) {
                    head = head.next;
                    slow = slow.next;    
                }
                return slow;
            }
        }
        return null;
    }
}
