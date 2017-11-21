// https://leetcode.com/problems/perfect-number/
// We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
// 
// Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
// Example:
// Input: 28
// Output: True
// Explanation: 28 = 1 + 2 + 4 + 7 + 14
// Note: The input number n will not exceed 100,000,000. (1e8)
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 0 || num == 1) return false;
        Set<Integer> set = new HashSet<>(14);
        int sum = 1;
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                if (set.add(num / i)) sum += num / i;
                if (set.add(i)) sum += i;
            }
        }
        return sum == num;
    }
}
