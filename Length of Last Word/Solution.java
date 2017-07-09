public class Solution {
    public int lengthOfLastWord(String s) {
        int lenght = 0;
        char[] array = s.trim().toCharArray();
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == ' ') {
                return lenght;
            } else {
                lenght++;
            }
        }
         return lenght;
    }
}
