public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int current, List<Integer> temp, List<List<Integer>> result) {
        for (int i = current; i < candidates.length; i++) {
            if (i > current && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            backtrack(candidates, i + 1, temp, result);
            temp.remove(temp.size() - 1);

        }
        result.add(new ArrayList<>(temp));
    }
    
}
