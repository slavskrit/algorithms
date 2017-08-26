// https://leetcode.com/problems/add-digits
// 
// 
// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit. 
// 
// 
// For example:
// 
// 
// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
// 
// Follow up:
// Could you do it without any loop/recursion in O(1) runtime?
// 
// Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
public class Solution {
    public int addDigits(int num) {
        while(num != 0) {
            int result = 0;
            int current = num;
            while(current != 0) {
                result += current % 10;
                current/= 10;
            }
            num = result;
            if (num / 10 == 0) {
                return result;
            }
        }
        return 0;
    }
}
