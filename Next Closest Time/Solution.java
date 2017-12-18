// https://leetcode.com/problems/next-closest-time
// 
// Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.
// 
// You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
// 
// Example 1:
// 
// Input: "19:34"
// Output: "19:39"
// Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
// Example 2:
// 
// Input: "23:59"
// Output: "22:22"
// Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
class Solution {
    public String nextClosestTime(String time) {
        Integer[] ti = new Integer[] {time.charAt(0) - '0', time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
        Integer[] backup = ti.clone();
        Integer h = null, m = null;
        boolean[] timeline = new boolean[2500];
        for (int h1 : ti) {
            if (h1 > 2) continue;
            for (int h2: ti) {
                if (h1 == 2 && h2 > 4) continue;
                for (int m1 : ti) {
                    if (m1 > 5) continue;
                    for (int m2: ti) {
                        timeline[h1 * 1000 + h2 * 100 + m1 * 10 + m2] = true;
                    }
                }
            }
        }
        int start = backup[0] * 1000 + backup[1] * 100 + backup[2] * 10 + backup[3];
        for (int i = start + 1; i <= 2401; i++) {
            if (i > 2400) i = 0;
            if (timeline[i]) {
                h = i / 100;
                m = i % 100;
                break;
            }
        }
        String result = "";
        if (h < 10) result += "0";
        result += h + ":";
        if (m < 10) result += "0";
        result += m;
        return result;
    }
}
