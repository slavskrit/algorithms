// https://leetcode.com/problems/repeated-string-match
// 
// Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.
// 
// For example, with A = "abcd" and B = "cdabcdab".
// 
// Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").
// 
// Note:
// The length of A and B will be between 1 and 10000.
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int result = 0;
        StringBuilder sb = new StringBuilder();
        while (sb.length() < B.length()) {
            sb.append(A);
            result++;
        }
        if (sb.toString().contains(B)) return result;
        sb.append(A);
        if (sb.toString().contains(B)) return result + 1;
        return -1;
    }
}
