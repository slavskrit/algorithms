// https://leetcode.com/problems/coin-change
//
// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
// 
// Example 1:
// coins = [1, 2, 5], amount = 11
// return 3 (11 = 5 + 5 + 1)
// 
// Example 2:
// coins = [2], amount = 3
// return -1.
// 
// Note:
// You may assume that you have an infinite number of each kind of coin.
// 
// Credits:
// Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
class Solution {
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        if (length == 0 || amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        for (int i = 0; i < length; i++) {
            int coin = coins[i];
            if (coin > amount) break;
            dp[coin] = 1;
            for (int j = coin + 1; j <= amount; j++) {
                int left = dp[j - coin];
                if (left == 0) continue;
                int current = dp[j] == 0 ? Integer.MAX_VALUE : dp[j];
                dp[j] = Math.min(left + 1, current);
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
