// https://leetcode.com/problems/generalized-abbreviation
// 
// Write a function to generate the generalized abbreviations of a word.
// 
// Example:
// Given word = "word", return the following list (order does not matter):
// ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        helper(result, word, 0, 0, "");
        return result;
    }
    
    private void helper(List<String> result, String word, int cursor, int length, String temp) {
        if (cursor == word.length()) {
            if (length > 0) temp += length;
            result.add(temp);
            return;
        }
        helper(result, word, cursor + 1, length + 1, temp);
        helper(result, word, cursor + 1, 0         , temp
               + (length > 0 ? length : "")
               + word.charAt(cursor)
        );
    }
    
}
