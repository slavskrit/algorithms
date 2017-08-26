// https://leetcode.com/problems/excel-sheet-column-number
// 
// Related to question Excel Sheet Column Title
// Given a column title as appear in an Excel sheet, return its corresponding column number.
// For example:
//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
// Credits:Special thanks to @ts for adding this problem and creating all test cases.
public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        double multiplicator;
        for (int i = 0; i < s.length(); i++) {
            multiplicator = Math.pow(26, s.length() - i - 1);
            if (multiplicator == 0) {
                result += s.charAt(i) - 'A' + 1 ;
            } else {
                result += (s.charAt(i) - 'A' + 1) * multiplicator ;
            }

        }
        return result;
    }
}
