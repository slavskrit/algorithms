// https://leetcode.com/problems/shortest-distance-to-a-character/description/ 
// 
// Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
// 
// Example 1:
// 
// Input: S = "loveleetcode", C = 'e'
// Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//  
// 
// Note:
// 
// S string length is in [1, 10000].
// C is a single character, and guaranteed to be in string S.
// All letters in S and C are lowercase.
class Solution {
    public int[] shortestToChar(String S, char C) {
        char[] c = S.toCharArray();
        int length = c.length;
        int[] result = new int[length];
        int t = 0;
        for (int i = 0; i < length; i++) {
            if (c[i] == C) {
                // left
                int pointer = i - 1;
                t = 1;
                while (pointer >= 0 && result[pointer] == 0
                        && c[pointer] != C
                        || pointer >= 0 && result[pointer] > t) {
                    result[pointer--] = t++;
                }
                t = 1;
                pointer = i + 1;
                // right
                while (pointer < length && result[pointer] == 0
                        && c[pointer] != C
                        || pointer < length && result[pointer] > t) {
                    result[pointer++] = t++;
                }
                result[i] = 0;
                i = pointer - 1;
            }
        }
        return result;
    }
}
