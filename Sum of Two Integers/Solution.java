// https://leetcode.com/problems/sum-of-two-integers
// 
// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
// Example:
// Given a = 1 and b = 2, return 3.
// 
// Credits:Special thanks to @fujiaozhu for adding this problem and creating all test cases.
public class Solution {
    public int getSum(int a, int b) {
      if (a == 0) return b;
    	if (b == 0) return a;
    	while (b != 0) {
    		int i = a & b;
    		a = a ^ b;
    		b = i << 1;
    	}
    	return a;
    }
}
