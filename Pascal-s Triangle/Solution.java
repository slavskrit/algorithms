public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        while (numRows-- > 0) {
            if (result.isEmpty()) {
                List<Integer> array = new ArrayList<>();
                array.add(1);
                result.add(array);
                continue;
            }
            List<Integer> previous = result.get(result.size() - 1);
            List<Integer> current = new ArrayList<>();
            current.add(1);
            for (int i = 1; i < previous.size(); i++) {
                current.add(previous.get(i - 1) + previous.get(i));
            }
            current.add(1);
            result.add(current);
        }
        return result;
    }
}
