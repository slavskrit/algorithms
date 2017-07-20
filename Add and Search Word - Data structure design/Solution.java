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
