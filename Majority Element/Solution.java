public class Solution {
    public int majorityElement(int[] nums) {
        int counter = 0, result = 0;
        for (int i : nums) {
            if (counter == 0) {
                result = i;
                counter++;
            }
            else if (i == result) counter++;
            else counter--;
        }
        return result;
    }
}
