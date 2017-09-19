"""
https://leetcode.com/problems/map-sum-pairs

Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
"""
class MapSum:

    class TrieNode:
        def __init__(self, value):
            self.value = value
            self.sum = 0
            self.is_word = False
            self.letters = {}

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = self.TrieNode(0)

    def insert(self, key, val):
        """
        :type key: str
        :type val: int
        :rtype: void
        """
        current = self.root
        val = int(val)
        for i in key:
            temp = current.letters.get(i)
            if temp:
                current = temp
            else:
                current.letters[i] = self.TrieNode(i)
                current = current.letters[i]
            current.sum += val
        if current.is_word:  # If this already on Trie, iterate again and decrease sum
            val = current.sum - val
            current = self.root
            for i in key:
                current = current.letters.get(i)
                current.sum -= val
        current.is_word = True

    def sum(self, prefix):
        """
        :type prefix: str
        :rtype: int
        """
        current = self.root
        for i in prefix:
            temp = current.letters.get(i)
            if temp:
                current = temp
            else:
                return 0
        return current.sum

# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
