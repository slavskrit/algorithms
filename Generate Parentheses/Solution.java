public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", 0, 0, n);
        return result;
    }

    private void helper(List<String> result, String s, int open, int close, int n) {
        if (s.length() == n * 2) result.add(s);
        else {
            if (open < n) helper(result, s + "(", open + 1, close, n);
            if (close < open) helper(result, s + ")", open, close + 1, n);
        }
    }
}
