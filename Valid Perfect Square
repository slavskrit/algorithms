public class Solution {
    public boolean isPerfectSquare(int num) {
        long i = num;
        while (i * i > num) {
            i = (i + num / i) / 2;
        }
        return i * i == num;
    }
}
