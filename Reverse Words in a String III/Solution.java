public class Solution {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int l = array.length;
        int i = 0;
        for (int k = 0; k < l; k++) {
            if (array[k] == ' ') {
                reverse(array, i, k);
                i = k + 1;
            }
        }
        reverse(array, i, l);
        return new String(array);
    }

    private void reverse(char[] array, int start, int end) {
        while (start < end){
            char t = array[start];
            array[start++] = array[--end];
            array[end] = t;
        }
    }
}
