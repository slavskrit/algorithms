// https://leetcode.com/problems/max-stack
// 
// Design a max stack that supports push, pop, top, peekMax and popMax.
// 
// push(x) -- Push element x onto stack.
// pop() -- Remove the element on top of the stack and return it.
// top() -- Get the element on the top.
// peekMax() -- Retrieve the maximum element in the stack.
// popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
// Example 1:
// MaxStack stack = new MaxStack();
// stack.push(5); 
// stack.push(1);
// stack.push(5);
// stack.top(); -> 5
// stack.popMax(); -> 5
// stack.top(); -> 1
// stack.peekMax(); -> 5
// stack.pop(); -> 1
// stack.top(); -> 5
// Note:
// -1e7 <= x <= 1e7
// Number of operations won't exceed 10000.
// The last four operations won't be called when stack is empty.
class MaxStack {

    /** initialize your data structure here. */
    private Deque<Integer> deque;
    private PriorityQueue<Integer> pq;


    public MaxStack() {
        deque = new ArrayDeque<>();
        pq = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void push(int x) {
        deque.push(x);
        pq.offer(x);
    }

    public int pop() {
        int i = deque.pop();
        pq.remove(i);
        return i;
    }

    public int top() {
        return deque.peek();
    }

    public int peekMax() {
        return pq.peek();
    }

    public int popMax() {
        int i = pq.poll();
        Deque<Integer> temp = new ArrayDeque<>();
        while (!deque.isEmpty() && deque.peek() != i) {
            temp.push(deque.pop());
        }
        deque.pop();
        while (!temp.isEmpty()) deque.push(temp.pop());
        return i;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
