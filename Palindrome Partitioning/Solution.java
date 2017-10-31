// https://leetcode.com/problems/palindrome-partitioning
// 
// Given a string s, partition s such that every substring of the partition is a palindrome.
// 
// Return all possible palindrome partitioning of s.
// 
// For example, given s = "aab",
// Return
// 
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]
// 
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result, new ArrayList<>());
        return result;
    }

    private void backtrack(char[] array, int cursor, List<List<String>> result, List<String> temp) {
        if (cursor == array.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = cursor; i < array.length; i++) {
                if (isPalindrome(array, cursor, i)) {
                    temp.add(new String(array, cursor, i - cursor + 1));
                    backtrack(array, i + 1, result, temp);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(char[] array, int left, int right) {
        while (left < right) {
            if (array[left++] != array[right--]) return false;
        }
        return true;
    }
}
