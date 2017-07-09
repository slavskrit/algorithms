public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int temp = 0;
        for(int i: nums) {
            if (i == 1) {
                temp++;
            } else {
                if (result < temp) {
                    result = temp;
                }
                temp = 0;
            }
        }
        return Math.max(result, temp);
    }
}
