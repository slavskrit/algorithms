public class Solution {
    public boolean checkRecord(String s) {
        char[] c = s.toCharArray();
        int length = c.length;
        if (length == 0) return true;
        boolean aWasBefore = false;
        for (int i = 0; i < length - 1; i++) {
            if (c[i] == 'A') {
                if (aWasBefore) {
                    return false;
                } else {
                    aWasBefore = true;
                }
            } else if (c[i] == 'L') {
                if (i > 0 && c[i - 1] == 'L' && c[i + 1] == 'L') {
                    return false;
                }
            }
        }
        if (aWasBefore && c[length - 1] == 'A') return false; 
        return true;
    }
}
