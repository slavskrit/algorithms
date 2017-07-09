public class Solution {
    public int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE;
        long second=Long.MIN_VALUE;
        long third=Long.MIN_VALUE;
        for(int i:nums){
            if(i>first){
                third=second;
                second=first;
                first=i;
            }else if(i==first)
                continue;
            else if(i>second){
                third=second;
                second=i;
            }else if(i==second)
                continue;
            else if(i>third){
                third=i;
            }
        }
        return third==Long.MIN_VALUE?(int)first:(int)third;
    }
}
