// https://leetcode.com/problems/palindrome-pairs
// 
// Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
// 
// Example 1:
// Given words = ["bat", "tab", "cat"]
// Return [[0, 1], [1, 0]]
// The palindromes are ["battab", "tabbat"]
// Example 2:
// Given words = ["abcd", "dcba", "lls", "s", "sssll"]
// Return [[0, 1], [1, 0], [3, 2], [2, 4]]
// The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
// Credits:
// Special thanks to @dietpepsi for adding this problem and creating all test cases.
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j <= word.length(); j++) {
                char[] array = word.toCharArray();
                String left = reverse(array, j, word.length());
                String right = reverse(array, 0, j);
                if (isPalindrome(left)) {
                    Integer position = map.get(right);
                    if (position != null && position != i) {
                        result.add(Arrays.asList(i, position));
                    }
                }
                if (!right.isEmpty() && isPalindrome(right)) {
                    Integer position = map.get(left);
                    if (position != null && position != i) {
                        result.add(Arrays.asList(position, i));
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private String reverse(char[] array, int start, int end) {
        char[] result = new char[end - start];
        int left = 0;
        int right = result.length - 1;
        while (start <= --end) {
            result[left++] = array[end];
            result[right--] = array[start++];
        }
        return new String(result);
    }
}
