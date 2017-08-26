// https://leetcode.com/problems/decode-string
// 
// 
// Given an encoded string, return it's decoded string.
// 
// 
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// 
// You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
// Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
// 
// Examples:
// 
// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
// 
// 
public class Solution {
    int cursor = 0;
    int length = 0;

    public String decodeString(String s) {
        if (s == null || s.isEmpty()) return "";
        char[] array = s.toCharArray();
        cursor = 0;
        length = array.length;
        return helper(array);
    }

    private String helper(char[] array) {
        StringBuilder sb = new StringBuilder();
        while (cursor < length && array[cursor] != ']') {
            if (Character.isDigit(array[cursor])) {
                int repeat = 0;
                while (cursor < length && Character.isDigit(array[cursor])) {
                    repeat = repeat * 10 + array[cursor] - '0';
                    cursor++;
                }
                cursor++;
                String temp = helper(array);
                cursor++;
                while (repeat-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(array[cursor]);
                cursor++;
            }
        }
        return sb.toString();
    }
}
