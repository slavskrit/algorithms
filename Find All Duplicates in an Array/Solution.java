public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[nums.length + 1];
        for(int i: nums) {
            temp[i]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 2) result.add(i);
        }
        return result;
    }
}
