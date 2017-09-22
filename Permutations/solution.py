"""
https://leetcode.com/problems/permutations

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
"""
class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        self.helper(nums, 0, result, len(nums))
        return result

    def helper(self, nums, current, result, max_current):
        if current == max_current:
            return result.append(nums[:])
        for i in range(current, max_current):
            nums[i], nums[current] = nums[current], nums[i]
            self.helper(nums, current + 1, result, max_current)
            nums[i], nums[current] = nums[current], nums[i]
