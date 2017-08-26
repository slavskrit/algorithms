// https://leetcode.com/problems/minimum-index-sum-of-two-lists
// 
// 
// Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of favorite restaurants represented by strings. 
// 
// 
// You need to help them find out their common interest with the least list index sum. If there is a choice tie between answers, output all of them with no order requirement. You could assume there always exists an answer.
// 
// Example 1:
// 
// Input:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
// Output: ["Shogun"]
// Explanation: The only restaurant they both like is "Shogun".
// 
// 
// Example 2:
// 
// Input:
// ["Shogun", "Tapioca Express", "Burger King", "KFC"]
// ["KFC", "Shogun", "Burger King"]
// Output: ["Shogun"]
// Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
// 
// 
// Note:
// 
// The length of both lists will be in the range of [1, 1000].
// The length of strings in both lists will be in the range of [1, 30].
// The index is starting from 0 to the list length minus 1.
// No duplicates in both lists.
// 
// 
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
