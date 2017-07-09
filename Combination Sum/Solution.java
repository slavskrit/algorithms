public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        recursion(result, candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void recursion(ArrayList<List<Integer>> result, int[] candidates, int target, List<Integer> temp, int s) {
        if (target < 0) return;
        else if (target == 0) {
            result.add(new ArrayList<>(temp));
        }
        else {
            for (int i = s; i < candidates.length; i++) {
                temp.add(candidates[i]);
                recursion(result, candidates, target - candidates[i], temp, i);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
