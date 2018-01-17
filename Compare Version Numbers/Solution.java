// https://leetcode.com/problems/compare-version-numbers
// 
// Compare two version numbers version1 and version2.
// If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
// 
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
// 
// Here is an example of version numbers ordering:
// 
// 0.1 < 1.1 < 1.2 < 13.37
// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.
class Solution {
    public int compareVersion(String version1, String version2) {
        Queue<Integer> first = parse(version1);
        Queue<Integer> second = parse(version2);
        while (!first.isEmpty() && !second.isEmpty()) {
            int f = first.poll();
            int s = second.poll();
            if (f > s) return 1;
            else if (f < s) return -1;
        }
        while (!first.isEmpty() && first.peek() == 0) first.poll();
        while (!second.isEmpty() && second.peek() == 0) second.poll();
        if (first.isEmpty() && second.isEmpty()) return 0;
        return first.size() - second.size() > 0 ? 1 : -1;
    }

    private Queue<Integer> parse(String version) {
        Queue<Integer> v = new LinkedList<>();
        int temp = 0;
        for (char c : version.toCharArray()) {
            if (c == '.') {
                v.offer(temp);
                temp = 0;
            } else {
                temp = temp * 10 + c - '0';
            }
        }
        v.offer(temp);
        return v;
    }
}
