"""
https://www.hackerrank.com/challenges/maximum-element/problem

You have an empty sequence, and you will be given  queries. Each query is one of these three types:

1 x  -Push the element x into the stack.
2    -Delete the element present at the top of the stack.
3    -Print the maximum element in the stack.
Input Format

The first line of input contains an integer, . The next  lines each contain an above mentioned query. (It is guaranteed that each query is valid.)

Constraints 
 
 

Output Format

For each type  query, print the maximum element in the stack on a new line.

Sample Input

10
1 97
2
1 20
2
1 26
1 20
2
3
1 91
3
Sample Output

26
91
"""

values_len = int(input().split()[0])
stack = []
while values_len:
    row = input().strip().split()
    if len(row) == 2:
        value = int(row[1])
        temp = 0 if not stack else stack[-1][1]
        stack.append((value, max(temp, value)))
    else:
        if row[0] == '2':
            temp = stack.pop()[1]
            if stack:
                maximum = stack[-1][1]
            else:
                maximum = 0
        if row[0] == '3':
            print(stack[-1][1])
    values_len -= 1
