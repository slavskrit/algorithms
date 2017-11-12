// https://leetcode.com/problems/matchsticks-to-square
// 
// Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
// 
// Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
// 
// Example 1:
// Input: [1,1,2,2,2]
// Output: true
// 
// Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
// Example 2:
// Input: [3,3,3,3,4]
// Output: false
// 
// Explanation: You cannot find a way to form a square with all the matchsticks.
// Note:
// The length sum of the given matchsticks is in the range of 0 to 10^9.
// The length of the given matchstick array will not exceed 15.
class Solution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int sum = 0;
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int t = nums[l];
            nums[l++] = nums[r];
            nums[r--] = t;
        }
        if (nums[0] <= 0) return false;
        for (int i : nums) sum += i;
        if (sum % 4 != 0) return false;
        int toFind = sum / 4;
        return dfs(0, toFind, toFind, toFind, toFind, nums);
    }

    private boolean dfs(int cursor, int a, int b, int c, int d, int[] nums) {
        if (cursor == nums.length) return a == 0 && b == 0 && c == 0 && d == 0;
        boolean result = false;
        if (nums[cursor] <= a) {
            result = dfs(cursor + 1, a - nums[cursor], b, c, d, nums);
        }
        if (!result && nums[cursor] <= b) {
            result = dfs(cursor + 1, a, b - nums[cursor], c, d, nums);
        }
        if (!result && nums[cursor] <= c) {
            result = dfs(cursor + 1, a, b, c - nums[cursor], d, nums);
        }
        if (!result && nums[cursor] <= d) {
            result = dfs(cursor + 1, a, b, c, d - nums[cursor], nums);
        }
        return result;
    }
}
