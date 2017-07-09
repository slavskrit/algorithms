public class NumArray {
    
    private int summ = 0;
    private int[] array;

    public NumArray(int[] nums) {
        array = nums;
        for(int i: array) {
            summ += i;
        }
    }
    
    public int sumRange(int i, int j) {
        int result = summ;
        for(int l = 0; l < i; l++) {
            result -= array[l];
        }
        
        for(int r = array.length - 1; r > j; r--) {
            result -= array[r];
        }
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
