""""
https://leetcode.com/problems/longest-valid-parentheses

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
"""
class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        result = 0
        stack = []
        d = {}
        for position, bracket in enumerate(s):
            if bracket == '(':
                stack.append(bracket)
            if bracket == ')':
                if not stack:
                    continue
                if stack[-1] == '(':
                    stack.pop()
                    value = max(d.get(position - 1, 0), d.get(position - 2, 0)) + 2
                    value += d.get(position - value, 0)
                    result = max(result, value)
                    d[position] = value
        return result
