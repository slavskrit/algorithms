// https://leetcode.com/problems/permutation-in-string
// 
// Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
// 
// Example 1:
// 
// Input:s1 = "ab" s2 = "eidbaooo"
// Output:True
// Explanation: s2 contains one permutation of s1 ("ba").
// 
// 
// Example 2:
// 
// Input:s1= "ab" s2 = "eidboaoo"
// Output: False
// 
// 
// Note:
// 
// The input strings only contain lower case letters.
// The length of both given strings is in range [1, 10,000].
// 
// 
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int first = 0;
        int second = s1.length();
        char[] f = s1.toCharArray();
        char[] array = s2.toCharArray();
        int[] firstBucket = new int[26];
        int[] secondBucket = new int[26];
        int length = array.length;
        for (int i = first; i < second; i++) {
            firstBucket[f[i] - 'a']++;
            secondBucket[array[i] - 'a']++;
        }
        while (second < length) {
            if (check(firstBucket, secondBucket)) return true;
            secondBucket[array[first] - 'a']--;
            secondBucket[array[second] - 'a']++;
            first++; second++;
        }
        return check(firstBucket, secondBucket);
    }

    private boolean check(int[] firstBucket, int[] secondBucket) {
        for (int i = 0; i < firstBucket.length; i++) {
            if (firstBucket[i] != secondBucket[i]) return false;
        }
        return true;
    }
}
