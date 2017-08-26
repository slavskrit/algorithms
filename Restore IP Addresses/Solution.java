// https://leetcode.com/problems/restore-ip-addresses
// 
// Given a string containing only digits, restore it by returning all possible valid IP address combinations.
// 
// For example:
// Given "25525511135",
// 
// 
// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
// 
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        int len = s.length();
        for (int i = 1; i < 4; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String a = s.substring(0, i);
                    String b = s.substring(i, j);
                    String c = s.substring(j, k);
                    String d = s.substring(k, len);
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        result.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValid(String s) {
        if (s.length() > 3 || s.length() < 1 || Integer.parseInt(s) > 255 || s.length() != 1 && s.charAt(0) == '0') {
            return false;
        }
        return true;
    }
}
