// https://leetcode.com/problems/buddy-strings/
// 
// Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
// 
// 
// 
// Example 1:
// 
// Input: A = "ab", B = "ba"
// Output: true
// Example 2:
// 
// Input: A = "ab", B = "ab"
// Output: false
// Example 3:
// 
// Input: A = "aa", B = "aa"
// Output: true
// Example 4:
// 
// Input: A = "aaaaaaabc", B = "aaaaaaacb"
// Output: true
// Example 5:
// 
// Input: A = "", B = "aa"
// Output: false
// 
// 
// Note:
// 
// 0 <= A.length <= 20000
// 0 <= B.length <= 20000
// A and B consist only of lowercase letters.
class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.isEmpty()) return false;
        char a = ' ';
        char b = ' ';
        int meet = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                if (meet > 2) return false;
                meet++;
                if (a == ' ') {
                    a = A.charAt(i);
                    b = B.charAt(i);
                } else {
                    if (a != B.charAt(i) || b != A.charAt(i)) return false;
                }
            }
        }
        if (meet == 2) return true;
        int[] bucket = new int[26];
        for (int i = 0; i < A.length(); i++) {
            System.out.println(A.charAt(i));
            bucket[A.charAt(i) - 'a']++;
            if (bucket[A.charAt(i) - 'a'] >= 2) return true;
        }
        return false;
    }
}
