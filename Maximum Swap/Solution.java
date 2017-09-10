// https://leetcode.com/problems/maximum-swap
// Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
// 
// Example 1:
// Input: 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.
// 
// Example 2:
// Input: 9973
// Output: 9973
// Explanation: No swap.
// 
// Note:
// The given number is in the range [0, 108]
class Solution {
    public int maximumSwap(int num) {
        // We could use constant space since we have limitation in problem.
        int[] array = new int[9];
        int[] bucket = new int[10];
        int cursor = 8;
        // Parse into into array.
        while (num != 0) {
            int t = num % 10;
            bucket[t]++;
            array[cursor--] = t;
            num /= 10;
        }
        // Iterate through array and looking for a greater value following after this digit.
        main: for (int i = cursor + 1; i < array.length; i++) {
            if (array[i] < 9) {
                for (int j = 9; j > array[i]; j--) { // Not a squre since it's not depenging on length.
                    if (bucket[j] != 0) {
                        // Since we are sure that we have a digit, we go from behind and swap em.
                        for (int k = array.length - 1; k >= i; k--) { 
                            if (array[k] == j) {
                                int temp = array[i];
                                array[i] = array[k];
                                array[k] = temp;
                                break main;
                            }
                        }
                    }
                }
            } else {
                bucket[array[i]]--;
            }
        }
        int result = 0;
        int tens = 1;
        // Make a integer from an array.
        for (int i = array.length - 1; i >= 0; i--) {
            result += array[i] * tens;
            tens *= 10;
        }
        return result;
    }
}
