public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(int n, int k, int current, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = current; i < n; i++) {
            temp.add(i + 1);
            backtrack(n, k, i + 1, result, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
