// https://leetcode.com/problems/custom-sort-string
// 
// S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
// 
// S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
// 
// Return any permutation of T (as a string) that satisfies this property.
// 
// Example :
// Input: 
// S = "cba"
// T = "abcd"
// Output: "cbad"
// Explanation: 
// "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
// Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
//  
// 
// Note:
// 
// S has length at most 26, and no character is repeated in S.
// T has length at most 200.
// S and T consist of lowercase letters only.
class Solution {
    public String customSortString(String S, String T) {
        int[] positions = new int[26];
        int[] count = new int[26];
        char[] result = new char[T.length()];
        for (int i = 0 ; i < S.length(); i++) {
            positions[S.charAt(i) - 'a'] = i + 1;
        }
        for (int i = 0 ; i < T.length(); i++) {
            count[T.charAt(i) - 'a']++;
        }
        int cursor = 0;
        char next = getNext(positions, count);
        while (next != ' ') {
            result[cursor++] = next;
            next = getNext(positions, count);
        }
        return new String(result);
    }

    private char getNext(int[] positions, int[] count) {
        int position = 27;
        int value = 27;
        int tail = 0;
        int tailPosition = 0;
        for (int i = 0; i < 26; i++) {
            if (positions[i] > 0 && positions[i] < value) {
                value = positions[i];
                position = i;
            }
            if (tail < count[i]) {
                tailPosition = i;
                tail = count[i];
            }
        }
        if (position < 27) {
            if (--count[position] == 0) {
                positions[position] = 0;
            }
            return (char) (position + 'a');
        } else if (tail > 0) {
            --count[tailPosition];
            return (char) (tailPosition+ 'a');
        }
        return ' ';
    }
}
