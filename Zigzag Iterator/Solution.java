// https://leetcode.com/problems/zigzag-iterator
// 
// Given two 1d vectors, implement an iterator to return their elements alternately.
// 
// For example, given two 1d vectors:
// 
// v1 = [1, 2]
// v2 = [3, 4, 5, 6]
// By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
// 
// Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
// 
// Clarification for the follow up question - Update (2015-09-18):
// The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:
// 
// [1,2,3]
// [4,5,6,7]
// [8,9]
// It should return [1,4,8,2,5,9,3,6,7].
public class ZigzagIterator {

    private int cursor;
    private int length;
    private int[] positions;
    private List<Integer>[] lists;
    private Integer toReturn;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.cursor = 0;
        this.length = 2;
        // for k lists we just add oll of them
        lists = new List[length];
        this.positions = new int[length];
        lists[0] = v1;
        lists[1] = v2;
        findNext();
    }

    private void findNext() {
        if (cursor == length) cursor = 0;
        int isEmpty = 0;
        while (positions[cursor] >= lists[cursor].size()) {
            if (isEmpty++ >= length) {
                toReturn = null;
                return;
            }
            cursor++;
            if (cursor == length) cursor = 0;
        }
        this.toReturn = lists[cursor].get(positions[cursor]);
        positions[cursor++]++;
    }

    public int next() {
        Integer toReturn = this.toReturn;
        findNext();
        return toReturn;
    }

    public boolean hasNext() {
        return toReturn != null;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
