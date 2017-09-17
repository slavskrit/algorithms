"""
https://www.hackerrank.com/challenges/game-of-thrones/problem

Dothraki are planning an attack to usurp King Robert's throne. King Robert learns of this conspiracy from Raven and plans to lock the single door through which the enemy can enter his kingdom.

But, to lock the door he needs a key that is an anagram of a certain palindrome string.

The king has a string composed of lowercase English letters. Help him figure out whether any anagram of the string can be a palindrome or not.

Input Format

A single line which contains the input string.

Each character of the string is a lowercase English letter.

Output Format

A single line which contains YES or NO in uppercase.

Sample Input 0

aaabbbb
Sample Output 0

YES
Explanation 0

A palindrome permutation of the given string is bbaaabb. 

Sample Input 1

cdefghmnopqrstuvw
Sample Output 1

NO
Explanation 1

You can verify that the given string has no palindrome permutation. 

Sample Input 2

cdcdcdcdeeeef
Sample Output 2

YES
Explanation 2

A palindrome permutation of the given string is ddcceefeeccdd.
"""
#!/bin/python3

import sys

def gameOfThrones(s):
    from collections import Counter
    count = Counter(s)
    odd = 0
    for i in count.values():
        if i % 2 == 0:
            continue
        else:
            odd += 1
            if odd > 1:
                break
    return "YES" if odd < 2 else "NO"

s = input().strip()
result = gameOfThrones(s)
print(result)
