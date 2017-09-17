"""
https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem

Hackerland is a one-dimensional city with  houses, where each house  is located at some  on the -axis. The Mayor wants to install radio transmitters on the roofs of the city's houses. Each transmitter has a range, , meaning it can transmit a signal to all houses  units of distance away.

Given a map of Hackerland and the value of , can you find and print the minimum number of transmitters needed to cover every house in the city? (Every house must be covered by at least one transmitter) Each transmitter must be installed on top of an existing house.

Input Format

The first line contains two space-separated integers describing the respective values of  (the number of houses in Hackerland) and  (the range of each transmitter). 
The second line contains  space-separated integers describing the respective locations of each house (i.e., ).

Output Format

Print a single integer denoting the minimum number of transmitters needed to cover all the houses.

Sample Input 0

5 1
1 2 3 4 5
Sample Output 0

2
Explanation 0

Sample Input 1

8 2
7 2 4 6 5 9 12 11 
Sample Output 1

3
"""
#!/bin/python3

n, k = input().strip().split(' ')
n, k = [int(n), int(k)]
x = sorted([int(x_temp) for x_temp in input().strip().split(' ')])
result = left = right = 0
for i in range(0, len(x)):
    if x[i] > right:  # if we we are currently in range
        if left == 0:  # if left border is not set, we set it to current position
            left = x[i]
        elif x[i] > left + k:  # if current house is not in range we will place transmitter to the previous house
            result += 1
            left = x[i]  
            if x[i] <= x[i - 1] + k:  # if both left houses are in range, we have to find a new position for a left
                left = 0  
            right = x[i - 1] + k  # update right pointer
if left > right:  # if we forgot to cover a last house we just check that we reach it
    result += 1
print(result)
