public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int temp[] = new int[nums.length];
        for (int i: nums) {
            temp[i - 1] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp[i] != 1) result.add(i + 1);
        }
        return result;
    }
}
