// https://leetcode.com/problems/integer-to-roman
// 
// Given an integer, convert it to a roman numeral.
// 
// Input is guaranteed to be within the range from 1 to 3999.
class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder(10);
        int t = 0;
        String[][] d = new String[][] {
                {"", "I", "II", "III", "VI", "V", "IV", "IIV", "IIIV", "XI", "X"},
                {"", "X", "XX", "XXX", "LX", "L", "XL", "XXL", "XXXL", "CX", "C"},
                {"", "C", "CC", "CCC", "DC", "D", "CD", "CCD", "CCCD", "MC", "M"},
                {"", "M", "MM", "MMM"},
        };
        while (num > 0) {
            sb.append(d[t][num % 10]);
            num /= 10;
            t++;
        }
        return sb.reverse().toString();
    }
}
