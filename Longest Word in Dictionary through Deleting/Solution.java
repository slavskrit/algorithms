public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String result = "";
        for (String string : d) {
            if (contains(s, string)) {
                if (string.length() > result.length()) {
                    result = string;
                } else if (string.length() == result.length()) {
                    if (isGreaterLexicographical(result, string)) {
                        result = string;
                    }
                }
            }
        }
        return result;
    }

    private boolean contains(String a, String b) {
        for (int i = 0, k = 0; i <= a.length() && k <= b.length(); i++) {
            if (i == a.length() && k == b.length()) return true;
            if (i == a.length() ) return false;
            if (k == b.length()) return true;
            if (a.charAt(i) == b.charAt(k)) {
                k++;
            }
        }
        return true;
    }

    private boolean isGreaterLexicographical(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (a.charAt(i) > b.charAt(i)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
