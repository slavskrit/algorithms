public class Solution {
    
    public String reverseWords(String s) {
        if (s.length() == 0) return s;
        char[] word = s.toCharArray();
        int length = word.length;
        reverse(word, 0, length - 1);
        int first = 0;
        int second = 1;
        int start = 0;
        int end = length - 1;
        while (second < length) {
            while (first < length && word[first] == ' ') first++;
            while (second < length && word[second] != ' ') second++;
            reverse(word, first, second - 1);
            first = second++ + 1;
        }
        reverse(word, first, second - 1);
        while (start < length && word[start] == ' ') start++;
        while (end >= start && word[end] == ' ') end--;
        end = removeSpacesBetween(word, start, end);
        return start == end ? "" : new String(word, start, end - start);
    }

    private int removeSpacesBetween(char[] word, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (word[i] != ' ') {
                word[start++] = word[i];
            } else {
                if (word[start - 1] != ' ') {
                    word[start++] = ' ';
                }
            }
        }
        return start;
    }

    private void reverse(char[] word, int l, int r) {
        while (l < r) {
            char t = word[l];
            word[l++] = word[r];
            word[r--] = t;
        }
    }
}
