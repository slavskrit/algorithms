// https://leetcode.com/problems/reverse-words-in-a-string-iii
// 
// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
// Example 1:
// 
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
// 
// 
// Note:
// In the string, each word is separated by single space and there will not be any extra space in the string.
// 
public class Solution {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int l = array.length;
        int i = 0;
        for (int k = 0; k < l; k++) {
            if (array[k] == ' ') {
                reverse(array, i, k);
                i = k + 1;
            }
        }
        reverse(array, i, l);
        return new String(array);
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end){
            char t = array[start];
            array[start++] = array[--end];
            array[end] = t;
        }
    }
}
