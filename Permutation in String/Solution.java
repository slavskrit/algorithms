public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        int first = 0;
        int second = s1.length();
        char[] f = s1.toCharArray();
        char[] array = s2.toCharArray();
        int[] firstBucket = new int[26];
        int[] secondBucket = new int[26];
        int length = array.length;
        for (int i = first; i < second; i++) firstBucket[f[i] - 'a']++;
        for (int i = first; i < second; i++) secondBucket[array[i] - 'a']++;
        while (second < length) {
            if (check(firstBucket, secondBucket)) return true;
            else {
                secondBucket[array[first] - 'a']--;
                secondBucket[array[second] - 'a']++;
                first++; second++;
            }
        }
        return check(firstBucket, secondBucket);
    }

    private boolean check(int[] firstBucket, int[] secondBucket) {
        for (int i = 0; i < firstBucket.length; i++) {
            if (firstBucket[i] != secondBucket[i]) return false;
        }
        return true;
    }
}
