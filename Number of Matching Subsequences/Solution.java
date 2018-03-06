// https://leetcode.com/problems/number-of-matching-subsequences
// 
// Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
// 
// Example :
// Input: 
// S = "abcde"
// words = ["a", "bb", "acd", "ace"]
// Output: 3
// Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
// Note:
// 
// All words in words and S will only consists of lowercase letters.
// The length of S will be in the range of [1, 50000].
// The length of words will be in the range of [1, 5000].
// The length of words[i] will be in the range of [1, 50].
class Solution {
    class Node {
        private int pointer;
        private char[] word;
        Node next;
        Node prev;

        Node(String word) {
            this.word = word.toCharArray();
            this.pointer = 0;
        }

        public boolean isDone() {
            return pointer == word.length;
        }

        void increment() {
            pointer++;
        }

        int getIndex() {
            return word[pointer] - 'a';
        }
    }

    private void addToArray(Node[] array, Node newNode) {
        Node next = array[newNode.getIndex()].next;
        array[newNode.getIndex()].next = newNode;
        newNode.prev = array[newNode.getIndex()];
        if (next != null) {
            next.prev = newNode;
            newNode.next = next;
        }
    }

    public int numMatchingSubseq(String S, String[] words) {
        int result = 0;
        Node[] list = new Node[26];
        for (int i = 0; i < 26; i++) list[i] = new Node("dummy");
        for (String word : words) {
            Node newNode = new Node(word);
            addToArray(list, newNode);
        }
        for (char c : S.toCharArray()) {
            Node current = list[c - 'a'].next;
            while (current != null) {
                Node next = current.next;
                current.increment();
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                current.prev.next = current.next;
                current.prev = null;
                current.next = null;
                if (current.isDone()) {
                    result++;
                } else {
                    addToArray(list, current);
                }
                current = next;
            }
        }
        return result;
    }
}
