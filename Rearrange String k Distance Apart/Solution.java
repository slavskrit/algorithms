// https://leetcode.com/problems/rearrange-string-k-distance-apart
// 
// Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.
// 
// All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".
// 
// Example 1:
// s = "aabbcc", k = 3
// 
// Result: "abcabc"
// 
// The same letters are at least distance 3 from each other.
// Example 2:
// s = "aaabc", k = 3 
// 
// Answer: ""
// 
// It is not possible to rearrange the string.
// Example 3:
// s = "aaadbbcc", k = 2
// 
// Answer: "abacabcd"
// 
// Another possible answer is: "abcabcda"
// 
// The same letters are at least distance 2 from each other.
// Credits:
// Special thanks to @elmirap for adding this problem and creating all test cases.
class Solution {
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> (o2.getValue() != o1.getValue()
                        ? o2.getValue() - o1.getValue()
                        : o1.getKey().compareTo(o2.getKey())
        ));
        Queue<Map.Entry<Character, Integer>> wait = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s.length());
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        queue.addAll(map.entrySet());
        while (!queue.isEmpty()) {
            Map.Entry<Character, Integer> entry = queue.poll();
            sb.append(entry.getKey());
            entry.setValue(entry.getValue() - 1);
            wait.offer(entry);
            if (wait.size() >= k) {
                entry = wait.poll();
                if (entry.getValue() > 0) queue.offer(entry);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
