// https://leetcode.com/problems/plus-one-linked-list
// 
// Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
// 
// You may assume the integer do not contain any leading zero, except the number 0 itself.
// 
// The digits are stored such that the most significant digit is at the head of the list.
// 
// Example:
// Input:
// 1->2->3
// 
// Output:
// 1->2->4
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(1);
        if (head.val == 0) return dummy;
        dummy.next = head;
        ListNode first = head;
        ListNode second = head;
        while (second != null) {
            if (second.val != 9) {
                first = second;
            }
            second = second.next;
        }
        first.val++;
        if (first.val == 10) first.val = 0;
        second = first.next;
        while (second != null) {
            second.val = 0;
            second = second.next;
        }
        if (first == head && first.val == 0) return dummy;
        return dummy.next; 
    }
}
