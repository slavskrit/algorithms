public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int[] temp = nums.clone();
        Arrays.sort(temp);
        int f = 0;
        int s = length - 1;
        if (temp[0] != nums[0] && temp[length - 1] != nums[length - 1]) return length;
        for (int i = f; i < length; i++) {
            if (nums[i] != temp[i]) {
                f = i;
                break;
            }
        }
        for (int i = s; i >= 0; i--) {
            if (nums[i] != temp[i]) {
                s = i;
                break;
            }
        }
        if (f == 0 && s == length - 1) return 0;
        return s - f + 1;
    }
}
