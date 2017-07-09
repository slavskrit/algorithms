public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.add(chars[i]);
            } else {
                if (stack.empty()) {
                    return false;
                }
                char temp = stack.pop();
                if (temp == '[' && chars[i] != ']') {
                    return false;
                } else if (temp == '{' && chars[i] != '}') {
                    return false;
                } else if (temp == '(' && chars[i] != ')') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
