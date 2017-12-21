// https://leetcode.com/problems/insert-interval
// 
// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
// 
// You may assume that the intervals were initially sorted according to their start times.
// 
// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
// 
// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
// 
// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int cursor = 0;
        if (intervals.isEmpty()) {
            intervals.add(newInterval);
            return intervals;
        }
        if (intervals.get(cursor).start > newInterval.end) {
            intervals.add(0, newInterval);
            return intervals;
        }
        while (cursor < intervals.size() && intervals.get(cursor).end < newInterval.start) {
            cursor++;
        }
        if (cursor == intervals.size()) {
            intervals.add(newInterval);
            return intervals;
        }
        if (intervals.get(cursor).start > newInterval.end) {
            intervals.add(cursor, newInterval);
        }
        int pointer = cursor;
        while (cursor < intervals.size() && newInterval.end >= intervals.get(cursor).start) {
            intervals.get(cursor).start = Math.min(newInterval.start, intervals.get(cursor).start);
            intervals.get(pointer).end = Math.max(intervals.get(cursor).end, newInterval.end);
            cursor++;
        }
        pointer++;
        while (cursor < intervals.size() && pointer < intervals.size()) {
            intervals.set(pointer++, intervals.get(cursor));
            cursor++;
        }
        while (cursor > pointer) {
            intervals.remove(--cursor);
        }
        return intervals;
    }
}
