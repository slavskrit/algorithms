// https://leetcode.com/problems/replace-words
// 
// In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
//
// Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
//
// You need to output the sentence after the replacement.
//
// Example 1:
// Input: dict = ["cat", "bat", "rat"]
// sentence = "the cattle was rattled by the battery"
// Output: "the cat was rat by the bat"
// Note:
// The input will only have lower-case letters.
// 1 <= dict words number <= 1000
// 1 <= sentence words number <= 1000
// 1 <= root length <= 100
// 1 <= sentence words length <= 1000
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Map<String, String> map = new HashMap<>();
        Set<String> set = new HashSet<>(dict);
        String[] sentenceSplitted = sentence.split(" ");
        for (String token: sentenceSplitted) {
            for (int i = 1; i < token.length(); i++) {
                String search = token.substring(0, i);
                if (set.contains(search)) {
                    map.put(token, search);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String token : sentenceSplitted) {
            sb.append(map.getOrDefault(token, token));
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
