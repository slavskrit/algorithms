public class Solution {
    private boolean binarySearch(int[] array, int target) {
        int min = 0;
        int max = array.length - 1;
        if (min == max && array[0] == target) return true;
        while (min < max) {
            int mid = min + (max - min / 2);
            if (array[min] == target || array[mid] == target || array[max] == target) return true;
            if (array[mid] > target) {
                max = mid - 1;
            }
            if (array[mid] < target) {
                min = mid;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0 && matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                if (binarySearch(matrix[i], target)) return true;
            }
        }
        return false;
    }
}
