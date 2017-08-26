// https://leetcode.com/problems/merge-k-sorted-lists
// 
// 
// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
// 
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        while (!heap.isEmpty()) {
            ListNode temp = heap.poll();
            cursor.next = temp;
            if (temp.next != null) heap.offer(temp.next);
            temp.next = null;
            cursor = cursor.next;
        }
        return dummy.next;
    }
}
