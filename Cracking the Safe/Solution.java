// https://leetcode.com/problems/cracking-the-safe
// 
// There is a box protected by a password. The password is n digits, where each letter can be one of the first k digits 0, 1, ..., k-1.
// 
// You can keep inputting the password, the password will automatically be matched against the last n digits entered.
// 
// For example, assuming the password is "345", I can open it when I type "012345", but I enter a total of 6 digits.
// 
// Please return any string of minimum length that is guaranteed to open the box after the entire string is inputted.
// 
// Example 1:
// Input: n = 1, k = 2
// Output: "01"
// Note: "10" will be accepted too.
// Example 2:
// Input: n = 2, k = 2
// Output: "00110"
// Note: "01100", "10011", "11001" will be accepted too.
// Note:
// n will be in the range [1, 4].
// k will be in the range [1, 10].
// k^n will be at most 4096.
class Solution {
    public String crackSafe(int n, int k) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        int total = (int) Math.pow(k, n);
        for (int i = 0; i < n; i++) sb.append('0');
        set.add(sb.toString());
        for (int i = 0; i < total; i++) {
            String previous = sb.substring(sb.length() - n + 1);
            for (int j = k - 1; j >= 0; j--) {
                String now = previous + j;
                if (!set.contains(now)) {
                    set.add(now);
                    sb.append(j);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
