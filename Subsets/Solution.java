public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int current, List<Integer> temp) {
        result.add(new ArrayList<>(temp));
        for (int i = current; i < nums.length; i++) {
            temp.add(nums[i]);
            backtrack(result, nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
