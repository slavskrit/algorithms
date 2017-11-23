// https://leetcode.com/problems/meeting-rooms-ii
// 
// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
// 
// For example,
// Given [[0, 30],[5, 10],[15, 20]],
// return 2.
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
    public int minMeetingRooms(Interval[] intervals) {
        int result = 0;
        List<int[]> list = new ArrayList<>(intervals.length * 2);
        for (Interval interval : intervals) {
            list.add(new int[] {interval.start, 1});
            list.add(new int[] {interval.end, -1});
        }
        list.sort((a, b) -> a[0] == b[0] ? a[1] : a[0] - b[0]);
        int max = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1] == 1) { // start
                if (list.get(i + 1)[0] == list.get(i)[0] && list.get(i + 1)[1] != list.get(i)[1] ) {
                    max--;
                }
                max++;
            } else {
                max--;
            }
            result = Math.max(result, max);
        }
        return result;
    }
}
