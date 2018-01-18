// https://leetcode.com/problems/24-game/
// 
// You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
// 
// Example 1:
// Input: [4, 1, 8, 7]
// Output: True
// Explanation: (8-4) * (7-1) = 24
// Example 2:
// Input: [1, 2, 1, 2]
// Output: False
// Note:
// The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
// Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
// You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
class Solution {
    boolean flag = false;

    public boolean judgePoint24(int[] nums) {
        flag = false;
        backtrack(nums, 0);
        return flag;
    }

    private void backtrack(int[] nums, int cursor) {
        if (flag) return;
        if (cursor == nums.length) {
            helper(nums);
        }
        for (int i = cursor; i < nums.length; i++) {
            swap(nums, i, cursor);
            backtrack(nums, cursor + 1);
            swap(nums, i, cursor);
        }
    }

    private void helper(int[] nums) {
        List<Double> left = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            left.add(nums[i] * 1.0);
            List<Double> right = new ArrayList<>();
            for (int j = i + 1; j < 4; j++) {
                right.add(nums[j] * 1.0);
            }
            Set<Double> f = calc(left);
            if (right.isEmpty()) {
                for (double ff : f) {
                    if ( Math.abs(ff - 24.0) < 1e-6) flag = true;
                }
            }
            Set<Double> r = calc(right);
            for (double ff : f) {
                for (double rr : r) {
                    if ( Math.abs(ff + rr - 24.0) < 1e-6
                        || Math.abs(ff - rr - 24.0) < 1e-6
                        || Math.abs(ff * rr - 24.0) < 1e-6
                    ) flag = true;
                    if (rr != 0 && Math.abs(ff / rr - 24.0) < 1e-6) flag = true;
                }
            }
        }
    }

    private Set<Double> calc(List<Double> left) {
        Set<Double> s = new HashSet<>();
        if (left.isEmpty()) return s;
        s.add(left.get(0));
        for (int i = 1; i < left.size(); i++) {
            double d = left.get(i);
            Set<Double> t = new HashSet<>();
            for (double a : s) {
                t.add(d + a);
                t.add(d - a);
                t.add(a * d);
                if (d != 0) t.add(d / a);
            }
            s = t;
        }
        return s;
    }

    private void swap(int[] nums, int l, int r) {
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
