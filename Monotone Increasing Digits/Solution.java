// https://leetcode.com/problems/monotone-increasing-digits
// 
// Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
// 
// (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
// 
// Example 1:
// Input: N = 10
// Output: 9
// Example 2:
// Input: N = 1234
// Output: 1234
// Example 3:
// Input: N = 332
// Output: 299
// Note: N is an integer in the range [0, 10^9].
class Solution {
    public int monotoneIncreasingDigits(int N) {
        if (N == 0) return 0;
        int[] helper = new int[11];
        int cursor = 10;
        int length = 0;
        while (N > 0) {
            length++;
            helper[cursor--] = N % 10;
            N /= 10;
        }
        cursor = 11;
        for (int i = 10; --length > 0; i--) {
            if (helper[i] < helper[i - 1]) {
                cursor = i;
                helper[i - 1]--;
            }
        }
        for (int i = cursor; i < 11; i++) {
            helper[i] = 9;
        }
        int result = 0;
        for (int i = 0; i < 11; i++) {
            result = result * 10 + helper[i];
        }
        return result;
    }
}
