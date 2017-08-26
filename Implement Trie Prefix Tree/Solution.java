// https://leetcode.com/problems/implement-trie-prefix-tree
//
//
// Implement a trie with insert, search, and startsWith methods.
//
//
// Note:
// You may assume that all inputs are consist of lowercase letters a-z.
//
public class Trie {
    
    class Node {
        char value;
        HashMap<Character, Node> childs;
        boolean isWord;

        public Node(char value) {
            this.value = value;
            this.childs = new HashMap<>();
            this.isWord = false;
        }

        @Override
        public boolean equals(Object obj) {
            Node t = (Node) obj;
            return this.value == t.value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] w = word.toCharArray();
        int l = w.length;
        Node current = root;
        for (int i = 0; i < l; i++) {
            Character c = w[i];
            Node t = new Node(c);
            Node node = current.childs.get(c);
            if (node == null) {
                current.childs.put(c, t);
                current = t;
            } else {
                current = node;
            }
        }
        current.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        int l = w.length;
        Node current = root;
        for (int i = 0; i < l; i++) {
            Node node = current.childs.get(w[i]);
            if (node == null) {
                return false;
            } else {
                current = node;
            }
        }
        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] w = prefix.toCharArray();
        int l = w.length;
        Node current = root;
        for (int i = 0; i < l; i++) {
            Node node = current.childs.get(w[i]);
            if (node == null) {
                return false;
            } else {
                current = node;
            }
        }
        return true;
    }
}
