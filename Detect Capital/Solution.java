public class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) return false;
        if (word.length() == 1) return true;
        if (word.length() == 2) {
            if (Character.isUpperCase(word.charAt(0))) {
                return true;
            } else if (Character.isUpperCase(word.charAt(1))) {
                return false;
            }
            return true;
        }
        if (Character.isUpperCase(word.charAt(0))) {
            if (Character.isUpperCase(word.charAt(1))) {
                for (int i = 1; i < word.length(); i++) {
                    if (!Character.isUpperCase(word.charAt(i))) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < word.length(); i++) {
                    if (!Character.isLowerCase(word.charAt(i))) {
                        return false;
                    }
                }
            }
            return true;
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (!Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
