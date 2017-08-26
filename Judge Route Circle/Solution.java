// https://leetcode.com/problems/judge-route-circle
// 
// 
// Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place. 
// 
// 
// The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
// 
// Example 1:
// 
// Input: "UD"
// Output: true
// 
// 
// Example 2:
// 
// Input: "LL"
// Output: false
// 
// 
public class Solution {
    public boolean judgeCircle(String moves) {
        int v = 0, h = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'U') v++;
            else if (c == 'D') v--;
            else if (c == 'R') h++;
            else if (c == 'L') h--;
        }
        return v == h && h == 0;
    }
}
