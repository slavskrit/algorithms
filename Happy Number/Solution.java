public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int temp = n;
        while (calculate(n) != temp && n != 1) {
            if (!set.add(n)) {
                return false;
            } else {
                n = calculate(n);
            }

        }
        return n == 1;
    }

    static int calculate(int n) {
        int result = 0;
        do {
            result += (n % 10) * (n % 10);
            n /= 10;
        } while  (n > 0);
        return result;
    }
}
