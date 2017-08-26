// https://leetcode.com/problems/excel-sheet-column-title
// 
// Given a positive integer, return its corresponding column title as appear in an Excel sheet.
// For example:
// 
//     1 -> A
//     2 -> B
//     3 -> C
//     ...
//     26 -> Z
//     27 -> AA
//     28 -> AB 
// Credits:Special thanks to @ifanchu for adding this problem and creating all test cases.
public class Solution {
    public String convertToTitle(int n) {
        if (n == 0) return "";
        StringBuilder result = new StringBuilder();
        while (n-- > 0) {
            result.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return result.reverse().toString();
    }
}
