public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> toResult = new HashSet<>();
        int left = 0;
        int right = 10;
        while (right <= s.length()) {
            String t = s.substring(left, right);
            if (!set.add(t)) {
                toResult.add(t);
            }
            left++;
            right++;
        }
        return new ArrayList<>(toResult);
    }
}
