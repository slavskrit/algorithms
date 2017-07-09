public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] values = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits.length() > 0) result.add("");
        for (int i = 0; i < digits.length(); i++) {
            String string= values[(int) digits.charAt(i) - '0'];
            List<String> temp = new ArrayList<>(result);
            result.clear();
            for (int k = 0; k < string.length(); k++) {
                for (String t : temp) {
                    t += string.charAt(k);
                    result.add(t);
                }
            }
        }
        return result;
    }
}
