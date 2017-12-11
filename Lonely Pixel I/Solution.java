Given a picture consisting of black and white pixels, find the number of black lonely pixels.

The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

Example:
Input: 
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

Output: 3
Explanation: All the three 'B's are black lonely pixels.
Note:
The range of width and height of the input 2D array is [1,500].
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int y = picture.length;
        if (y == 0) return 0;
        int x = picture[0].length;
        int h = 0;
        int v = 0;
        for (int i = 0; i < y; i++) {
            boolean wasB = false;
            for (int j = 0; j <= x; j++) {
                if (j == x) {
                    if (wasB) v++;
                    break;
                }
                if (picture[i][j] == 'B') {
                    if (!wasB) {
                        wasB = true;
                    } else {
                        break;
                    }
                }
            }
        }
        for (int j = 0; j < x; j++) {
            boolean wasB = false;
            for (int i = 0; i <= y; i++) {
                if (i == y) {
                    if (wasB) h++;
                    break;
                }
                if (picture[i][j] == 'B') {
                    if (!wasB) {
                        wasB = true;
                    } else {
                        break;
                    }
                }
            }
        }
        return Math.min(v, h);
    }
}
