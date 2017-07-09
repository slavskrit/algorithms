public class Solution {
    public int getSum(int a, int b) {
      if (a == 0) return b;
    	if (b == 0) return a;
    	while (b != 0) {
    		int i = a & b;
    		a = a ^ b;
    		b = i << 1;
    	}
    	return a;
    }
}
