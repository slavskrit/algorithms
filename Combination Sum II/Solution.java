public class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int current, List<Integer> temp,List<List<Integer>> result) {
        if (target < 0 || current > candidates.length) return;
        if (0 == target) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = current; i < candidates.length; i++) {
                if (i > current && candidates[i] == candidates[i - 1]) continue;
                temp.add(candidates[i]);
                backtrack(candidates, target - candidates[i], i + 1, temp, result);
                temp.remove(temp.size() - 1);

            }
        }
    }

}
