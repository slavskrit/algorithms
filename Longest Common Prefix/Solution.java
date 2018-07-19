// https://leetcode.com/problems/longest-common-prefix
// 
// Write a function to find the longest common prefix string amongst an array of strings.
// 
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String result = strs[0];
        int current = 1;
        while (current < strs.length) {
            while (strs[current].indexOf(result) != 0) {
                result = result.substring(0, result.length() - 1);
            }
            current++;
        }
        return result;
    }
}

// without substring() and indexOf()
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1 || strs[0].isEmpty()) return strs[0];
        char[] helper = strs[0].toCharArray();
        int pointer = helper.length;
        for (int i = 1; i < strs.length; i++) {
            int p = 0;
            for (int j = 0; j < strs[i].length() && p < helper.length; j++) {
                if (helper[p] == strs[i].charAt(p)) {
                    p++;
                } else {
                    pointer = Math.min(pointer, p);
                }
            }
            pointer = Math.min(pointer, strs[i].length());
        }
        return strs[0].substring(0, pointer);
    }
}
