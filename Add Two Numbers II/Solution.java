// https://leetcode.com/problems/add-two-numbers-ii
// 
// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
// 
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
// 
// Follow up:
// What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
// 
// Example:
// 
// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> first = new LinkedList<>();
        Deque<ListNode> second = new LinkedList<>();
        ListNode current1 = l1;
        while (current1 != null) {
            first.push(current1);
            current1 = current1.next;
        }
        ListNode current2 = l2;
        while (current2 != null) {
            second.push(current2);
            current2 = current2.next;
        }
        ListNode tail = null;
        ListNode current = null;
        while (!first.isEmpty() || !second.isEmpty()) {
            int value = (!first.isEmpty() ? first.pop().val : 0) + (!second.isEmpty() ? second.pop().val : 0);
            if (tail != null && tail.val > 9) {
                value++;
                tail.val -= 10;
            }
            current = new ListNode(value);
            current.next = tail;
            tail = current;
        }
        if (current != null && current.val > 9) {
            ListNode dummy = new ListNode(1);
            current.val -= 10;
            dummy.next = current;
            return dummy;
        }
        return current;
    }
}
