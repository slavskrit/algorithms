// https://leetcode.com/problems/number-of-segments-in-a-string
// 
// Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
// Please note that the string does not contain any non-printable characters.
// Example:
// 
// Input: "Hello, my name is John"
// Output: 5
// 
public class Solution {
    public int countSegments(String s) {
        int segments = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                flag = true;
            } else {
                if (flag) {
                    segments++;
                    flag = false;
                }
            }
        }
        if (flag) segments++;
        return segments;
    }
}
