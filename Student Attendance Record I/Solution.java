// https://leetcode.com/problems/student-attendance-record-i
// 
// You are given a string representing an attendance record for a student. The record only contains the following three characters:
// 
// 
// 
// 'A' : Absent. 
// 'L' : Late.
//  'P' : Present. 
// 
// 
// 
// A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).    
// You need to return whether the student could be rewarded according to his attendance record.
// Example 1:
// 
// Input: "PPALLP"
// Output: True
// 
// 
// Example 2:
// 
// Input: "PPALLL"
// Output: False
// 
// 
// 
public class Solution {
    public boolean checkRecord(String s) {
        char[] c = s.toCharArray();
        int length = c.length;
        if (length == 0) return true;
        boolean aWasBefore = false;
        for (int i = 0; i < length - 1; i++) {
            if (c[i] == 'A') {
                if (aWasBefore) {
                    return false;
                } else {
                    aWasBefore = true;
                }
            } else if (c[i] == 'L') {
                if (i > 0 && c[i - 1] == 'L' && c[i + 1] == 'L') {
                    return false;
                }
            }
        }
        if (aWasBefore && c[length - 1] == 'A') return false; 
        return true;
    }
}
