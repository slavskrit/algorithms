"""
https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem

We say that a string, , contains the word hackerrank if a subsequence of the characters in  spell the word hackerrank. For example, haacckkerrannkk does contain hackerrank, but haacckkerannk does not (the characters all appear in the same order, but it's missing a second r).

More formally, let  be the respective indices of h, a, c, k, e, r, r, a, n, k in string . If  is true, then  contains hackerrank.

You must answer  queries, where each query consists of a string, . For each query, print YES on a new line if contains hackerrank; otherwise, print NO instead.

Input Format

The first line contains an integer denoting  (the number of queries). 
Each line of the  subsequent lines contains a single string denoting .

Output Format

For each query, print YES on a new line if  contains hackerrank; otherwise, print NO instead.

Sample Input 0

2
hereiamstackerrank
hackerworld
Sample Output 0

YES
NO
Explanation 0

The characters of hackerrank are bolded in the string above. Because the string contains all the characters in hackerrank in the same exact order as they appear in hackerrank, we print YES on a new line.
 does not contain the last three characters of hackerrank, so we print NO on a new line.
 """
 #!/bin/python3

import sys

hackerrank = "hackerrank"
q = int(input().strip())
for _ in range(q):
    s = input().strip()
    if len(s) < len(hackerrank):
        print("NO")
    hlen = len(hackerrank)
    slen = len(s)
    first = second = 0
    while second < slen:
        if first < hlen and hackerrank[first] == s[second]:
            first += 1
        second += 1
    print("YES" if first == hlen else "NO")
