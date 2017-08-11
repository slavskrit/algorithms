public class Solution {
    int cursor = 0;
    int length = 0;

    public String decodeString(String s) {
        if (s == null || s.isEmpty()) return "";
        char[] array = s.toCharArray();
        cursor = 0;
        length = array.length;
        return helper(array);
    }

    private String helper(char[] array) {
        StringBuilder sb = new StringBuilder();
        while (cursor < length && array[cursor] != ']') {
            if (Character.isDigit(array[cursor])) {
                int repeat = 0;
                while (cursor < length && Character.isDigit(array[cursor])) {
                    repeat = repeat * 10 + array[cursor] - '0';
                    cursor++;
                }
                cursor++;
                String temp = helper(array);
                cursor++;
                while (repeat-- > 0) {
                    sb.append(temp);
                }
            } else {
                sb.append(array[cursor]);
                cursor++;
            }
        }
        return sb.toString();
    }
}
