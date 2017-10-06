"""
https://leetcode.com/problems/merge-intervals

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

"""
# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: List[Interval]
        """
        result = []
        i = sorted(intervals, key=lambda x: x.start)
        for interval in i:
            if result and interval.start <= result[-1].end <= interval.end:
                    result[-1].end = interval.end
            elif not result or interval.start > result[-1].end:
                result.append(interval)
        return result
