// https://leetcode.com/problems/push-dominoes/description/
// 
// There are N dominoes in a line, and we place each domino vertically upright.
// 
// In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
// 
// 
// 
// After each second, each domino that is falling to the left pushes the adjacent domino on the left.
// 
// Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
// 
// When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
// 
// For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
// 
// Given a string "S" representing the initial state. S[i] = 'L', if the i-th domino has been pushed to the left; S[i] = 'R', if the i-th domino has been pushed to the right; S[i] = '.', if the i-th domino has not been pushed.
// 
// Return a string representing the final state. 
// 
// Example 1:
// 
// Input: ".L.R...LR..L.."
// Output: "LL.RR.LLRRLL.."
// Example 2:
// 
// Input: "RR.L"
// Output: "RR.L"
// Explanation: The first domino expends no additional force on the second domino.
// Note:
// 
// 0 <= N <= 10^5
// String dominoes contains only 'L', 'R' and '.'
class Solution {
    public String pushDominoes(String dominoes) {
        char[] d = dominoes.toCharArray();
        int left = 0;
        int right = 0;
        boolean metRight = false;
        while (right < d.length) {
            if (d[right] == 'L') {
                if (metRight) {
                    int t = right;
                    while (left < t) {
                        d[left++] = 'R';
                        d[t--] = 'L';
                    }
                    left = right;
                    metRight = false;
                } else {
                    while (left < right) {
                        d[left++] = 'L';
                    }
                }
            } else if (d[right] == 'R') {
                while (metRight && left < right) {
                    d[left++] = 'R';
                }
                metRight = true;
                left = right;
            }
            right++;
        }
        while (metRight && left < right) {
            d[left++] = 'R';
        }
        return new String(d);
    }
}
