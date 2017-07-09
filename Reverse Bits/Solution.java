public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int a[] = new int[32];
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            a[i] = (n & bit) == 0 ? 0 : 1;
            bit *= 2;
        }
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            if (a[i] == 1) {
                result += 1;
            }
        }
        return result;
    }
}
