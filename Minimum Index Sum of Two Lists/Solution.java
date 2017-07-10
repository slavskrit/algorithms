public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        int l1 = list1.length;
        int l2 = list2.length;
        for (int i = 0; i < l1; i++) {
            map.put(list1[i], i);
        }
        List<String>[] helper = new ArrayList[l1 + l2];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < l2; i++) {
            Integer t = map.get(list2[i]);
            if (t == null) continue;
            int c = t + i;
            if (c < min) {
                min = c;
                if (helper[min] == null) {
                    helper[min] = new ArrayList<>();
                }
                helper[min].add(list2[i]);
            } else if (c == min) {
                helper[min].add(list2[i]);
            }
        }
        for (int i = 0; i <= l1 + l2; i++) {
            if (helper[i] != null) {
                return helper[i].toArray(new String[0]);
            }
        }
        return new String[0];
    }
}
