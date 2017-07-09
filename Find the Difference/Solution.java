public class Solution {
    public char findTheDifference(String s, String t) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();
        char answer = 0;
        for (int i = 0; i < ch2.length; i++) {
            answer += ch2[i];
        }
        for (int i = 0; i < ch1.length; i++) {
            answer -= ch1[i];
        }
        return answer;
    }
}
