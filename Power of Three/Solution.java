public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==1) return true;
 
    boolean result = false;
 
    while(n>0){
        int m = n%3;
        if(m==0){
            n=n/3;
            if(n==1)
                return true;
        }else{
            return false;
        }
    }
 
    return result;
    }
}
