// https://leetcode.com/problems/add-binary
// 
// 
// Given two binary strings, return their sum (also a binary string).
// 
// 
// For example,
// a = "11"
// b = "1"
// Return "100".
// 
public class Solution {
    public String addBinary(String a, String b) {
        String longest = a.length() > b.length() ? a : b;
        String shortest = longest == b ? a : b;
        char[] r = new char[longest.length() + 1];
        char[] l = longest.toCharArray();
        char[] s = shortest.toCharArray();
        r[0] = '1';
        int rc = r.length - 1;
        int lc = l.length - 1;
        int sc = s.length - 1;
        int add = 0;
        while (rc > 0) {
            if (sc < 0) {
                s[0] = '0';
                sc = 0;
            }
            if (l[lc] + s[sc] - '0' - '0' + add == 3) {
                r[rc] = '1';
                add = 1;
            } else if (l[lc] + s[sc] - '0' - '0' + add == 2) {
                r[rc] = '0';
                add = 1;
            } else if (l[lc] + s[sc] - '0' - '0' + add == 1 ) {
                r[rc] = '1';
                add = 0;
            } else {
                r[rc] = '0';
            }
            rc--; lc--; sc--;
        }
        return add == 1 ? new String(r) : new String(r, 1, r.length - 1);
    }
}
