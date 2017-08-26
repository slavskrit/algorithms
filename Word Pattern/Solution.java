// https://leetcode.com/problems/word-pattern
// 
// Given a pattern and a string str, find if str follows the same pattern.
//  Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
// 
// Examples:
// 
// pattern = "abba", str = "dog cat cat dog" should return true.
// pattern = "abba", str = "dog cat cat fish" should return false.
// pattern = "aaaa", str = "dog cat cat dog" should return false.
// pattern = "abba", str = "dog dog dog dog" should return false.
// 
// 
// 
// Notes:
// You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
// 
// Credits:Special thanks to @minglotus6 for adding this problem and creating all test cases.
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        char[] p = pattern.toCharArray();
        int l = p.length;
        if (l != arr.length) return false;
        HashMap<Character, String> map1 = new HashMap<>(l);
        HashMap<String, Character> map2 = new HashMap<>(l);
        for (int i = 0; i < l; i++) {
            String t = map1.get(p[i]);
            Character t1 = map2.get(arr[i]);
            if (t == null) {
                map1.put(p[i], arr[i]);
            } else {
                if (!t.equals(arr[i])) return false;
            }
            if (t1 == null) {
                map2.put(arr[i], p[i]);
            } else {
                if (t1 != p[i]) return false;
            }
        }
        return true;
    }
}
