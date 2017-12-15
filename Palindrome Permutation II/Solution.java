// https://leetcode.com/problems/palindrome-permutation-ii
// 
// Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
// 
// For example:
// 
// Given s = "aabb", return ["abba", "baab"].
// 
// Given s = "abc", return [].
class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        char[] array = s.toCharArray();
        char[] half = new char[array.length / 2];
        int[] counts = new int[256];
        int max = 0;
        for (char c : array) {
            counts[c]++;
            max = Math.max(max, counts[c]);
        }
        if (max == array.length) {
            result.add(s);
            return result;
        }
        char mid = ' ';
        for (int i = 0; i < 256; i++) {
            if (counts[i] % 2 != 0) {
                if (mid != ' ') return result;
                mid = (char) (i);
                counts[i] -= 1;
            }
        }
        int left = 0;
        for (int i = 0; i < 256; i++) {
            while (counts[i] > 1) {
                char c = (char) (i);
                half[left++] = c;
                counts[i] -= 2;
            }
        }
        backtrack(half, 0, result, mid, new HashSet<>());
        return result;
    }

    private void backtrack(char[] half, int cursor, List<String> result, char mid, Set<String> set) {
        if (cursor == half.length) {
            String toAdd = new String(half);
            if (mid != ' ') {
                toAdd += mid;
            }
            toAdd += new String(getReversedArray(half));
            if (!set.contains(toAdd)) result.add(toAdd);
            set.add(toAdd);
            return;
        }
        for (int i = cursor; i < half.length; i++) {
            swap(half, cursor, i);
            backtrack(half, cursor + 1, result, mid, set);
            swap(half, cursor, i);
        }

    }

    private char[] getReversedArray(char[] array) {
        char[] a = new char[array.length];
        for (int i = a.length - 1, j = 0; i >= 0; i--, j++) {
            a[j] = array[i];
        }
        return a;
    }

    private void swap(char[] half, int i, int j) {
        char temp = half[i];
        half[i] = half[j];
        half[j] = temp;
    }
}
