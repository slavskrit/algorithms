// https://leetcode.com/problems/text-justification
// 
// 
// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
// 
// 
// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
// 
// 
// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
// 
// 
// For the last line of text, it should be left justified and no extra space is inserted between words.
// 
// 
// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.
// 
// 
// Return the formatted lines as:
// 
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// 
// 
// 
// Note: Each word is guaranteed not to exceed L in length.
// 
// click to show corner cases.
// Corner Cases:
// 
// 
// A line other than the last line might contain only one word. What should you do in this case?
// In this case, that line should be left-justified.
// 
// 
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<StringBuilder> temp = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        int cursor = 0;
        for (int i = 0; i < words.length; i++) {
            queue.offer(words[i]);
        }
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty() && cursor + queue.peek().length() <= maxWidth) {
                if (sb.length() != 0) sb.append(" ");
                String t = queue.poll();
                sb.append(t);
                cursor += t.length();
                cursor++;
            }
            temp.add(sb);
            cursor = 0;
        }
        for (int i = 0; i < temp.size(); i++) {
            if (i == temp.size() - 1) result.add(justify(temp.get(i), maxWidth, true));
            else result.add(justify(temp.get(i), maxWidth, false));
        }
        return result;
    }

    private String justify(StringBuilder sb, int len, boolean ifLast) {
        if (ifLast) {
            while (sb.length() < len) {
                sb.append(" ");
            }
        } else {
            int lastWord = sb.length();
            while (sb.length() < len) {
                for (int i = 1; i < sb.length() - 1; i++) {
                    if (sb.length() == len) break;
                    if (sb.charAt(i) == ' ' && sb.charAt(i + 1) != ' ') {
                        sb.insert(i, " ");
                        i += 2;
                    }
                }
                if (sb.length() == lastWord) {
                    sb.append(" ");
                    lastWord++;
                }
            }
        }
        return sb.toString();
    }
}
