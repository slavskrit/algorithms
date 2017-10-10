"""
https://leetcode.com/problems/combination-sum-iv

Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.

Example:

nums = [1, 2, 3]
target = 4

The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

Note that different sequences are counted as different combinations.

Therefore the output is 7.
Follow up:
What if negative numbers are allowed in the given array?
How does it change the problem?
What limitation we need to add to the question to allow negative numbers?

Credits:
Special thanks to @pbrother for adding this problem and creating all test cases.
"""
class Solution(object):
    def combinationSum4(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        memorize = {}

        def dfs(nums, target):
            result = 0
            if not nums or target < 0:
                return 0
            if target == 0:
                return 1
            if target in memorize:
                return memorize.get(target)
            for i in nums:
                result += dfs(nums, target - i)
            memorize[target] = result
            return result
        return dfs(nums, target)
