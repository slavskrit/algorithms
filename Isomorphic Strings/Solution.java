public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] firstBucket = new int[256];
        int[] secondBucket = new int[256];
        int[] firstHelper = new int[s.length()];
        int[] secondHelper = new int[s.length()];
        for (int i = 0, firstCursor = 0, secondCursor = 0; i < s.length(); i++) {
            if (firstBucket[s.charAt(i)] == 0) firstBucket[s.charAt(i)] = firstCursor++;
            if (secondBucket[t.charAt(i)] == 0) secondBucket[t.charAt(i)] = secondCursor++;
        }
        for (int i = 0; i < s.length(); i++) {
            firstHelper[i] = firstBucket[s.charAt(i)];
            secondHelper[i] = secondBucket[t.charAt(i)];
        }
        for (int i = 0; i < firstHelper.length; i++) {
            if (firstHelper[i] != secondHelper[i]) return false;
        }
        return true;
    }
}
