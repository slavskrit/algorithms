public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        int[] helper = new int[32];
        int minInteger = 0;
        for (int i : nums) {
            int c = 0;
            if (i == Integer.MIN_VALUE) {
                minInteger++;
            } else if (i < 0) {
                i = -i;
            }
            while (i > 0) {
                helper[c++] += i & 1;
                i >>>= 1;
            }
        }
        if (minInteger == 1) return Integer.MIN_VALUE;
        int cursor = helper.length - 1;
        while (cursor >= 0 && helper[cursor] == 0) cursor--;
        while (cursor >= 0) {
            if (helper[cursor] != 0 && helper[cursor] % 3 != 0) {
                result += Math.pow(2, cursor);
            }
            cursor--;
        }
        short positive = 0;
        for (int i : nums) {
            if (i == result) {
                positive++;
            }
        }
        if (positive == 3 || positive == 0) {
            return -result;
        } else {
            return result;
        }
    }
}
