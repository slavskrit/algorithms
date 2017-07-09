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
