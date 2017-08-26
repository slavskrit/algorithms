// https://leetcode.com/problems/reverse-bits
// 
// Reverse bits of a given 32 bits unsigned integer.
// For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).
// 
// Follow up:
// If this function is called many times, how would you optimize it?
// 
// Related problem: Reverse Integer
// Credits:Special thanks to @ts for adding this problem and creating all test cases.
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int counter = 0;
        while (counter++ < 32) {
            result <<= 1;
            result |= n & 1;
            n >>>= 1;
        }
        return result;
    }
}
