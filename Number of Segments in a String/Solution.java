public class Solution {
    public int countSegments(String s) {
        int segments = 0;
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                flag = true;
            } else {
                if (flag) {
                    segments++;
                    flag = false;
                }
            }
        }
        if (flag) segments++;
        return segments;
    }
}
