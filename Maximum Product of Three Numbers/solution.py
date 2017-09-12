# https://leetcode.com/problems/maximum-product-of-three-numbers
#  
#  Given an integer array, find three numbers whose product is maximum and output the maximum product.
#  Example 1:
#  
#  Input: [1,2,3]
#  Output: 6
#  
#  
#  Example 2:
#  
#  Input: [1,2,3,4]
#  Output: 24
#  
#  
#  Note:
#  
#  The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
#  Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
#  
#  
class Solution:
    def maximumProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 3:
            return nums[0] * nums[1] * nums[2]
        maxvalue = 10001
        mina = minb = minc = maxvalue
        maxa = maxb = maxc = -maxvalue
        for i in nums:
            if i > 0:
                if i > maxa:
                    maxc = maxb
                    maxb = maxa
                    maxa = i
                elif i > maxb:
                    maxc = maxb
                    maxb = i
                elif i > maxc:
                    maxc = i
            if i <= 0:
                if i < mina:
                    minc = minb
                    minb = mina
                    mina = i
                elif i < minb:
                    minc = minb
                    minb = i
                elif i < minc:
                    minc = i
        if mina == maxvalue: mina = 0
        if minb == maxvalue: minb = 0
        if minc == maxvalue: minc = 0
        if maxa == -maxvalue: maxa = 0
        if maxb == -maxvalue: maxb = 0
        if maxc == -maxvalue: maxc = 0
        if maxa == 0: return mina * minb * minc
        return max(mina * minb * minc, mina * minb * maxa, maxa * maxb * maxc)
