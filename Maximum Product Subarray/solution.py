"""
https://leetcode.com/problems/maximum-product-subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
"""
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        minimum = maximum = result = nums.pop(0)
        for i in nums:
            temp = maximum
            maximum = max(maximum * i, minimum * i, i)
            minimum = min(temp * i, minimum * i, i)
            result = max(result, maximum, minimum)
        return result
