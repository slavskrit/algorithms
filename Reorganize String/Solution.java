// https://leetcode.com/problems/reorganize-string
// 
// Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
// 
// If possible, output any possible result.  If not possible, return the empty string.
// 
// Example 1:
// 
// Input: S = "aab"
// Output: "aba"
// Example 2:
// 
// Input: S = "aaab"
// Output: ""
// Note:
// 
// S will consist of lowercase letters and have length in range [1, 500].
class Solution {
    public String reorganizeString(String S) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0]));
        int[] bucket = new int[26];
        for (char c : S.toCharArray()) {
            bucket[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (bucket[i] != 0) pq.offer(new int[]{bucket[i], i});
        }
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != (char) (temp[1] + 'a')) {
                temp[0]--;
                sb.append((char) (temp[1] + 'a'));
            } else {
                if (pq.isEmpty()) return "";
                int[] current = pq.poll();
                sb.append((char) (current[1] + 'a'));
                if (--current[0] > 0) {
                    pq.offer(current);
                }
            }
            if (temp[0] > 0) {
                pq.offer(temp);
            }
        }
        return sb.toString();
    }
}
