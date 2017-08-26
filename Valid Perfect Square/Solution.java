// https://leetcode.com/problems/valid-perfect-square
// 
// Given a positive integer num, write a function which returns True if num is a perfect square else False.
// 
// Note: Do not use any built-in library function such as sqrt.
// 
// Example 1:
// 
// Input: 16
// Returns: True
// 
// 
// Example 2:
// 
// Input: 14
// Returns: False
// 
// 
// Credits:Special thanks to @elmirap for adding this problem and creating all test cases.
public class Solution {
    public boolean isPerfectSquare(int num) {
        long i = num;
        while (i * i > num) {
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }
}
