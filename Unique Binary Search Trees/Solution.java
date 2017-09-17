// https://leetcode.com/problems/unique-binary-search-trees
// 
// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
// 
// For example,
// Given n = 3, there are a total of 5 unique BST's.
// 
//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int left = 0;
            int right = i - 1;
            int temp = 0;
            while (right >= 0) {
                temp += dp[left++] * dp[right--];
            }
            dp[i] = temp;
        }
        return dp[n];
    }
}
