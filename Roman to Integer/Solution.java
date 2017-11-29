// https://leetcode.com/problems/roman-to-integer
// 
// Given a roman numeral, convert it to an integer.
// 
// Input is guaranteed to be within the range from 1 to 3999.
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'M') result += 1000;
            if (c == 'D') result += 500;
            if (c == 'C') result += 100;
            if (c == 'L') result += 50;
            if (c == 'X') result += 10;
            if (c == 'V') result += 5;
            if (c == 'I') result += 1;
        }
        if (s.contains("CD") || s.contains("CM")) result -= 200;
        if (s.contains("XL") || s.contains("XC")) result -= 20;
        if (s.contains("IX") || s.contains("IV")) result -= 2;
        return result;
    }
}
