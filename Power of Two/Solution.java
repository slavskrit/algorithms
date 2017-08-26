// https://leetcode.com/problems/power-of-two
// 
// 
// Given an integer, write a function to determine if it is a power of two.
// 
// Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & n - 1) == 0;
    }
}
