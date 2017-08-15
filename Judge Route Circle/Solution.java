public class Solution {
    public boolean judgeCircle(String moves) {
        int v = 0, h = 0;
        for (char c : moves.toCharArray()) {
            if(c == 'U') v++;
            else if(c == 'D') v--;
            else if(c == 'R') h++;
            else if(c == 'L') h--;
        }
        return v == h && h == 0;
    }
}
