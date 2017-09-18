// https://leetcode.com/problems/valid-palindrome-ii/
// 
// Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
// 
// Example 1:
// Input: "aba"
// Output: True
// Example 2:
// Input: "abca"
// Output: True
// Explanation: You could delete the character 'c'.
// Note:
// The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
class Solution {
    public boolean validPalindrome(String s) {
        char[] array = s.toCharArray();
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            if (array[left] != array[right]) {
                return helper(array, left + 1, right) || helper(array, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean helper(char[] array, int left, int right) {
        while (left < right) {
            if (array[left++] != array[right--]) return false;
        }
        return true;
    }
}
