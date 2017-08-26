// https://leetcode.com/problems/group-anagrams
// 
// Given an array of strings, group anagrams together.
// 
// For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
// Return:
// 
// [
//   ["ate", "eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note: All inputs will be in lower-case.
public class Solution {
    private static String badHash(String string) {
        char[] result = new char[26];
        int[] hash = new int[26];
        if (string.length() == 0) return "";
        for (int i = 0; i < string.length(); i++) {
            hash[string.charAt(i) - 'a']++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0) {
                result[i] = ' ';
            } else {
                result[i] = (char) hash[i];
            }
        }
        return new String(result);
    }

     public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String string: strs) {
            String t = badHash(string);
            List<String> temp = map.get(t);
            if (temp == null) {
                temp = new ArrayList<>();
                temp.add(string);
                map.put(t, temp);
            } else {
                temp.add(string);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
