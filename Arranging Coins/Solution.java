public class Solution {
    public int arrangeCoins(int n) {
        int rows = 0;
        int neededCoins = 1;
        while (n > 0 && n >= neededCoins) {
            n -= neededCoins;
            rows++;
            neededCoins++;
        }
        return rows;
    }
}
