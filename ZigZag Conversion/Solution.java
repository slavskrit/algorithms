// https://leetcode.com/problems/zigzag-conversion
// 
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
// 
// P   A   H   N
// A P L S I I G
// Y   I   R
// 
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:
// 
// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        char[] array = s.toCharArray();
        int length = array.length;
        StringBuilder result = new StringBuilder(length);
        StringBuilder[] helper = new StringBuilder[numRows];
        boolean isDown = true;
        int cursor = 0;
        for (char c : array) {
            if (helper[cursor] == null) helper[cursor] = new StringBuilder(numRows / 2);
            helper[cursor].append(c);
            cursor += isDown ? 1 : - 1;
            if (cursor == numRows - 1) {
                isDown = false;
            }
            if (cursor == 0) {
                isDown = true;
            }
        }
        for (StringBuilder sb : helper) {
            if (sb != null) result.append(sb);
        }
        return result.toString();
    }
}
