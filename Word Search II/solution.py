"""
https://leetcode.com/problems/word-search-ii

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.

click to show hint.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree) first.
"""
class Solution(object):
    def build_trie(self, words):
        for word in words:
            current = self.root
            for i in word:
                temp = current.get(i)
                if not temp:
                    current[i] = {}
                    temp = current.get(i)
                current = temp
            current['_'] = word

    def findWords(self, board, words):
        self.board = board
        max_y = len(board)
        max_x = len(board[0])
        self.root = {}
        self.build_trie(words)
        result = []
        for i in range(max_y):
            for j in range(max_x):
                self.crawl(i, j, self.root, result, board, max_y, max_x)
        return result

    def crawl(self, y, x, current, result, board, max_y, max_x):
        if current.get("_"):
            result.append(current.get("_"))
            del (current["_"])
            return
        if 0 <= x < max_x and 0 <= y < max_y and board[y][x] != '_' and current:
            temp = self.board[y][x]
            current = current.get(temp)
            if not current:
                return
            self.board[y][x] = '_'
            self.crawl(y + 1, x, current, result, board, max_y, max_x)
            self.crawl(y - 1, x, current, result, board, max_y, max_x)
            self.crawl(y, x + 1, current, result, board, max_y, max_x)
            self.crawl(y, x - 1, current, result, board, max_y, max_x)
            self.board[y][x] = temp
