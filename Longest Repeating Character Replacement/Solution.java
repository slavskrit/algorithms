// https://leetcode.com/problems/longest-repeating-character-replacement/
// 
// Given a string that consists of only uppercase English letters, you can replace any letter in the string with another letter at most k times. Find the length of a longest substring containing all repeating letters you can get after performing the above operations.
// 
// Note:
// Both the string's length and k will not exceed 104.
// 
// Example 1:
// 
// Input:
// s = "ABAB", k = 2
// 
// Output:
// 4
// 
// Explanation:
// Replace the two 'A's with two 'B's or vice versa.
// Example 2:
// 
// Input:
// s = "AABABBA", k = 1
// 
// Output:
// 4
// 
// Explanation:
// Replace the one 'A' in the middle with 'B' and form "AABBBBA".
// The substring "BBBB" has the longest repeating letters, which is 4.
class Solution {
    public int characterReplacement(String s, int k) {
        int[] bucket = new int[26];
		int i = 0, j = 0, result = 0;
		char[] a = s.toCharArray();
		while (j < a.length) {
			int temp = count(bucket);
			while (temp > k) {
				bucket[a[i] - 'A']--;
				i++;
				temp = count(bucket);
			}
			if (temp == k) result = Math.max(j - i, result);
			bucket[a[j] - 'A']++;
			j++;
		}
		if (count(bucket) <= k) result = Math.max(j - i, result);
		return result;
	}

	private int count(int[] bucket) {
		int max = 0;
		int count = 0;
		for (int i : bucket) {
			max = Math.max(max, i);
			if (i != 0) count += i;
		}
		return count - max;
	}
}
