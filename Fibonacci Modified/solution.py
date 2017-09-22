"""
https://www.hackerrank.com/challenges/fibonacci-modified/problem

This is kinda stupid problem and not related to DP but for handling big integer. That is why I used python for it.

"""

t1, t2, n = map(int, input().split()) 

while n != 1:
    temp = t1 + t2 * t2
    t1 = t2
    t2 = temp
    n -= 1
print(t1)
