// https://leetcode.com/problems/length-of-last-word
// 
// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
// If the last word does not exist, return 0.
// Note: A word is defined as a character sequence consists of non-space characters only.
// 
// For example, 
// Given s = "Hello World",
// return 5.
// 
public class Solution {
    public int lengthOfLastWord(String s) {
        int lenght = 0;
        char[] array = s.trim().toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == ' ') {
                return lenght;
            } else {
                lenght++;
            }
        }
         return lenght;
    }
}
