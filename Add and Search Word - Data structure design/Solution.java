// https://leetcode.com/problems/add-and-search-word-data-structure-design
// 
// 
// Design a data structure that supports the following two operations:
// 
// 
// void addWord(word)
// bool search(word)
// 
// 
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
// 
// For example:
// 
// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true
// 
// 
// Note:
// You may assume that all words are consist of lowercase letters a-z.
// 
// click to show hint.
// You should be familiar with how a Trie works. If not, please work on this problem: Implement Trie (Prefix Tree) first.
// 
public class WordDictionary {

    TrieNode root;
    TrieNode current;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    private class TrieNode {
        TrieNode[] letters = new TrieNode[26];
        boolean isCompleteWord;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.letters[word.charAt(i) - 'a'] != null) {
                node = node.letters[word.charAt(i) - 'a'];
            } else {
                node.letters[word.charAt(i) - 'a'] = new TrieNode();
                node = node.letters[word.charAt(i) - 'a'];
            }
        }
        node.isCompleteWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        current = root;
        return search(word, 0);
    }

    private boolean search(String word, int position) {
        if (word.length() == position) {
            return current.isCompleteWord;
        }
        if (word.charAt(position) == '.') {
            for (TrieNode node : current.letters) {
                if (node == null) continue;
                current = node;
                boolean b = search(word, position + 1);
                if (b) return true;
            }
        } else if (current.letters[word.charAt(position) - 'a'] != null) {
            current = current.letters[word.charAt(position) - 'a'];
            return search(word, position + 1);
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
