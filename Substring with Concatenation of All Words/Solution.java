public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> firstMap = new HashMap<>();
        for (String word : words) {
            Integer a = firstMap.get(word);
            if (a == null) firstMap.put(word, 1);
            else firstMap.put(word, a + 1);
        }
        int len = words[0].length();
        for (int start = 0, end = words.length * len; end <= s.length(); start++, end++) {
            if (contains(s.substring(start, end), firstMap, len)) {
                result.add(start);
            }
        }
        return result;
    }

    private boolean contains(String a, HashMap<String, Integer> firstMap, int len) {
        HashMap<String, Integer> map = new HashMap<>(firstMap);
        for (int start = 0, end = len; end <= a.length(); start += len, end += len) {
            String t = a.substring(start, end);
            Integer i = map.get(t);
            if (i == null || i <= 0) {
                return false;
            } else {
                map.put(t, i - 1);
            }
        }
        return true;
    }
}
