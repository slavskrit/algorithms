// https://leetcode.com/problems/happy-number
// 
// Write an algorithm to determine if a number is "happy".
// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
// Example: 19 is a happy number
// 
// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1
// 
// Credits:Special thanks to @mithmatt and @ts for adding this problem and creating all test cases.
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = n;
        while (calculate(n) != temp && n != 1) {
            if (!set.add(n)) {
                return false;
            } else {
                n = calculate(n);
            }

        }
        return n == 1;
    }

    static int calculate(int n) {
        int result = 0;
        do {
            result += (n % 10) * (n % 10);
            n /= 10;
        } while  (n > 0);
        return result;
    }
}
