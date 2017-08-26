// https://leetcode.com/problems/longest-word-in-dictionary-through-deleting
// 
// 
// Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
// 
// Example 1:
// 
// Input:
// s = "abpcplea", d = ["ale","apple","monkey","plea"]
// 
// Output: 
// "apple"
// 
// 
// 
// Example 2:
// 
// Input:
// s = "abpcplea", d = ["a","b","c"]
// 
// Output: 
// "a"
// 
// 
// Note:
// 
// All the strings in the input will only contain lower-case letters.
// The size of the dictionary won't exceed 1,000.
// The length of all the strings in the input won't exceed 1,000.
// 
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String string : d) {
            if (contains(s, string)) {
                if (string.length() > result.length()) {
                    result = string;
                } else if (string.length() == result.length()) {
                    if (isGreaterLexicographical(result, string)) {
                        result = string;
                    }
                }
            }
        }
        return result;
    }

    private boolean contains(String a, String b) {
        for (int i = 0, k = 0; i <= a.length() && k <= b.length(); i++) {
            if (i == a.length() && k == b.length()) return true;
            if (i == a.length() ) return false;
            if (k == b.length()) return true;
            if (a.charAt(i) == b.charAt(k)) {
                k++;
            }
        }
        return true;
    }

    private boolean isGreaterLexicographical(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (a.charAt(i) > b.charAt(i)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
