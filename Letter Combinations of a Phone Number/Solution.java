// https://leetcode.com/problems/letter-combinations-of-a-phone-number
// 
// Given a digit string, return all possible letter combinations that the number could represent.
// 
// 
// A mapping of digit to letters (just like on the telephone buttons) is given below.
// 
// 
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// 
// 
// Note:
// Although the above answer is in lexicographical order, your answer could be in any order you want.
// 
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
