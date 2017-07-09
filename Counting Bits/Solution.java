public class Solution {
    
    static int humming(int i) {
        int result = 0;
        while (i != 0) {
            result += i & 1;
            i >>>= 1;
        }
        return result;
    }
    
    public int[] countBits(int num) {
        int [] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = humming(i);
        }
        return result;
    }
}
