// https://leetcode.com/problems/rotate-string
// 
// We are given two strings, A and B.
// 
// A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
// 
// Example 1:
// Input: A = 'abcde', B = 'cdeab'
// Output: true
// 
// Example 2:
// Input: A = 'abcde', B = 'abced'
// Output: false
// Note:
// 
// A and B will have length at most 100.
class Solution {
     private int calcHash(char[] array, int start) {
        int iterations = 0;
        int hash = 31;
        int length = array.length;
        int i = 0;
        while (iterations++ < length) {
            i = array[(start) % length];
            hash *= i;
            hash += i;
            start++;
        }
        return hash;
    }

    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) return false;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int hashA = calcHash(a, 0);
        for (int i = 0; i < b.length; i++) {
            if (a[0] == b[i] && hashA == calcHash(b, i)) {
                return true;
            }
        }
        return false;
    }
}
