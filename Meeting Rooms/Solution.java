// https://leetcode.com/problems/meeting-rooms
// 
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
// 
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return false.
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
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals.length == 0) return true;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));
        int end = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < end) return false;
            else end = intervals[i].end;
        }
        return true;
    }
}
