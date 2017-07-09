public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        char[] p = pattern.toCharArray();
        int l = p.length;
        if (l != arr.length) return false;
        HashMap<Character, String> map1 = new HashMap<>(l);
        HashMap<String, Character> map2 = new HashMap<>(l);
        for (int i = 0; i < l; i++) {
            String t = map1.get(p[i]);
            Character t1 = map2.get(arr[i]);
            if (t == null) {
                map1.put(p[i], arr[i]);
            } else {
                if (!t.equals(arr[i])) return false;
            }
            if (t1 == null) {
                map2.put(arr[i], p[i]);
            } else {
                if (t1 != p[i]) return false;
            }
        }
        return true;
    }
}
