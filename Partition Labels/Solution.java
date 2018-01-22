// https://leetcode.com/problems/partition-labels
// 
// A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
// 
// Example 1:
// Input: S = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
// Note:
// 
// S will have length in range [1, 500].
// S will consist of lowercase letters ('a' to 'z') only.
class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        char[] array = S.toCharArray();
        int[] bucket = new int[26];
        for (int i = 0; i < array.length; i++) {
            bucket[array[i] - 'a'] = i;
        }
        int previousStart = 0;
        int maxJump = 0;
        for (int i = 0; i < array.length; i++) {
            maxJump = Math.max(maxJump, bucket[array[i] - 'a']);
            if (maxJump == i) {
                result.add(i - previousStart + 1);
                previousStart = i + 1;
                maxJump = i + 1;
            }
        }
        return result;
    }
}
