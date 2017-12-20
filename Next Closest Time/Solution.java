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
        char[] ch = time.toCharArray();
        Integer[] ti = new Integer[] {ch[0] - '0', ch[1] - '0', ch[3] - '0', ch[4] - '0'};
        Integer h = null, m = null;
        boolean[] timeline = new boolean[2401];
        for (int h1 : ti) {
            if (h1 <= 2) {
                for (int h2: ti) {
                    if (h1 != 2 || h2 <= 3) {
                        for (int m1 : ti) {
                            if (m1 <= 5) {
                                for (int m2: ti) {
                                    timeline[h1 * 1000 + h2 * 100 + m1 * 10 + m2] = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        int start = ti[0] * 1000 + ti[1] * 100 + ti[2] * 10 + ti[3];
        for (int i = start + 1; i <= 2401; i++) {
            if (i > 2400) i = 0;
            if (timeline[i]) {
                h = i / 100;
                m = i % 100;
                break;
            }
        }
        if (h < 9) {
            ch[0] = '0';
            ch[1] = (char) (h + '0');
        } else {
            ch[0] = (char) (h / 10 + '0');
            ch[1] = (char) (h % 10 + '0');
        }
        if (m < 9) {
            ch[3] = '0';
            ch[4] = (char) (m + '0');
        } else {
            ch[3] = (char) (m / 10 + '0');
            ch[4] = (char) (m % 10 + '0');
        }
        return new String(ch);
    }
}
