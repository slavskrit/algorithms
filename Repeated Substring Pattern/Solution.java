public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        char start = str.charAt(0);
        char end = str.charAt(str.length() - 1);
        List<Integer> indexes = new ArrayList<>();
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == start && str.charAt(i - 1) == end) {
                indexes.add(i);
            }
        }
        for (int index = 0; index < indexes.size(); index++) {
            for (int i = 0, helper = 0; i <= str.length(); i++) {
                if (i == str.length() && helper == 0) return true;
                if (i == str.length() && helper != 0) return false;
                if (str.charAt(i) == str.charAt(helper)) {
                    helper++;
                    if (helper == indexes.get(index)) helper = 0;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
