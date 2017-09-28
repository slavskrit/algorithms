"""
https://leetcode.com/problems/word-ladder

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
"""
class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        length = len(beginWord)
        visited = {beginWord}
        wordList = set(wordList)
        result = 0
        if endWord not in wordList:
            return result
        wordList.add(endWord)
        while endWord not in visited:
            to_add = set()
            for w in visited:
                for index in range(length):
                    temp = list(w)
                    for i in range(ord('a'), ord('z')):
                        temp[index] = chr(i)
                        word = "".join(temp)
                        if word in wordList:
                            to_add.add(word)
                            wordList.remove(word)
            result += 1
            if not to_add:
                return 0
            visited = to_add
        return result + 1
