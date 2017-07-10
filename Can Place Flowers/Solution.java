public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            boolean left = i < 1 ? flowerbed[i] == 0 : flowerbed[i - 1] == 0;
            boolean right = i >= length - 1 ? flowerbed[i] == 0 : flowerbed[i + 1] == 0;
            if (left && right && flowerbed[i] == 0) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }
}
