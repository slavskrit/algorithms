// https://leetcode.com/problems/palindrome-permutation
// 
// Given a string, determine if a permutation of the string could form a palindrome.
// 
// For example,
// "code" -> False, "aab" -> True, "carerac" -> True.
class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] ascii = new int[256];
        for (char c : s.toCharArray()) {
            ascii[c]++;
        }
        boolean odds = false;
        for (int i : ascii) {
            if ((i & 1) == 1) {
                if (odds) return false;
                odds = !odds;
            }
        }
        return true;
    }
}
