// https://leetcode.com/problems/reorder-list/
// 
// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
// 
// You may not modify the values in the list's nodes, only nodes itself may be changed.
// 
// Example 1:
// 
// Given 1->2->3->4, reorder it to 1->4->2->3.
// Example 2:
// 
// Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return;
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next != null) fast = fast.next;
		reverse(slow.next);
		slow.next = null;
		merge(head, fast);
	}

	private void merge(ListNode first, ListNode second) {
		ListNode temp1, temp2;
		while (first != null && second != null) {
			temp1 = first.next;
			first.next = second;
			temp2 = second.next;
			second.next = temp1;
			second = temp2;
			first = temp1;
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode next = head.next;
		while (next != null) {
			current.next = prev;
			prev = current;
			current = next;
			next = next.next;
		}
		current.next = prev;
		return current;
	}
}
