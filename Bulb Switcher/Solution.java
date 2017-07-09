public class Solution {
    public int bulbSwitch(int n) {
        if (n == 0) return 0;
        int step = 0;
        while (step * step < n) {
            step++;
        }
        if (Math.ceil(Math.sqrt(n)) * Math.ceil(Math.sqrt(n)) == n) {
            return step;
        }
        return step - 1;
    }
}
