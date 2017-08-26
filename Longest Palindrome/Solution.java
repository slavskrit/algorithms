// https://leetcode.com/problems/longest-palindrome
// 
// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
// This is case sensitive, for example "Aa" is not considered a palindrome here.
// Note:
// Assume the length of given string will not exceed 1,010.
// 
// Example: 
// 
// Input:
// "abccccdd"
// 
// Output:
// 7
// 
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
// 
// 
public class Solution {
    public int longestPalindrome(String s) {
        int a[] = new int[122-64];
        for (char c: s.toCharArray()) {
            a[c - 'A']++;
        }
        int result = 0;
        int one = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 1) one = 1;
            result += a[i] / 2;
        }
        return result * 2 + one;
    }
}
