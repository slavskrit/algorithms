/***
https://leetcode.com/problems/prefix-and-suffix-search

Given many words, words[i] has weight i.

Design a class WordFilter that supports one function, WordFilter.f(String prefix, String suffix). It will return the word with given prefix and suffix with maximum weight. If no word exists, return -1.

Examples:
Input:
WordFilter(["apple"])
WordFilter.f("a", "e") // returns 0
WordFilter.f("b", "") // returns -1
Note:
words has length in range [1, 15000].
For each test case, up to words.length queries WordFilter.f may be made.
words[i] has length in range [1, 10].
prefix, suffix have lengths in range [0, 10].
words[i] and prefix, suffix queries consist of lowercase letters only. ***/
class WordFilter:

    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.combinations = {}
        for index, word in enumerate(words):
            for l in range(0, len(word) + 1):
                for r in range(len(word), -1, -1):
                    self.combinations[(word[:l], word[r:])] = index

    def f(self, prefix, suffix):
        """
        :type prefix: str
        :type suffix: str
        :rtype: int
        """
        return self.combinations.get((prefix, suffix), -1)
        


# Your WordFilter object will be instantiated and called as such:
# obj = WordFilter(words)
# param_1 = obj.f(prefix,suffix)
