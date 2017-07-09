public class Solution {
    public String originalDigits(String s) {
        int[] hash = new int[10];
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'z': hash[0]++; break;
                case 'w': hash[2]++; break;
                case 'x': hash[6]++; break;
                case 's': hash[7]++; break;
                case 'g': hash[8]++; break;
                case 'u': hash[4]++; break;
                case 'f': hash[5]++; break;
                case 'h': hash[3]++; break;
                case 'i': hash[9]++; break;
                case 'o': hash[1]++; break;
            }
        }
        hash[7] -= hash[6];
        hash[5] -= hash[4];
        hash[3] -= hash[8];
        hash[9] = hash[9] - hash[8] - hash[5] - hash[6];
        hash[1] = hash[1] - hash[0] - hash[2] - hash[4];
        int len = 0;
        for(int i = 0; i < hash.length; i++) {
            len += hash[i];
        }
        char[] result = new char[len];
        int cursor = 0;
        for (int i = 0; i < hash.length; i++) {
            for (int k = 0; k < hash[i]; k++) {
                result[cursor++] = (char) (i + '0');
            }
        }
        return new String(result);
    }
}
