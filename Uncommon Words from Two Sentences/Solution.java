// https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
// 
// We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
// 
// A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
// 
// Return a list of all uncommon words. 
// 
// You may return the list in any order.
// 
//  
// 
// Example 1:
// 
// Input: A = "this apple is sweet", B = "this apple is sour"
// Output: ["sweet","sour"]
// Example 2:
// 
// Input: A = "apple apple", B = "banana"
// Output: ["banana"]
//  
// 
// Note:
// 
// 0 <= A.length <= 200
// 0 <= B.length <= 200
// A and B both contain only spaces and lowercase letters.
class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String a : A.split(" ")) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (String b : B.split(" ")) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new String[0]);
    }
}
