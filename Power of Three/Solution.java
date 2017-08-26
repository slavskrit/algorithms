// https://leetcode.com/problems/power-of-three
// 
// 
//     Given an integer, write a function to determine if it is a power of three.
// 
// 
// Follow up:
//     Could you do it without using any loop / recursion?
// 
// Credits:Special thanks to @dietpepsi for adding this problem and creating all test cases.
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
