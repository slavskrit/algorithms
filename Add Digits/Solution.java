public class Solution {
    public int addDigits(int num) {
        while(num != 0) {
            int result = 0;
            int current = num;
            while(current != 0) {
                result += current % 10;
                current/= 10;
            }
            num = result;
            if (num / 10 == 0) {
                return result;
            }
        }
        return 0;
    }
}
