// https://leetcode.com/problems/pascals-triangle-ii
//
// Given an index k, return the kth row of the Pascal's triangle.
//
// For example, given k = 3,
// Return [1,3,3,1].
//
//
// Note:
// Could you optimize your algorithm to use only O(k) extra space?
//
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if (rowIndex-- >= 0) {
            result.add(1);
        }
        if (rowIndex-- >= 0) {
            result.add(0, 1);
        }
        while (rowIndex-- >= 0) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 1; i < result.size(); i++) {
                int t = result.get(i) + result.get(i - 1);
                temp.add(t);
            }
            temp.add(0, 1);
            temp.add(1);
            result = temp;
        }
        return result;
    }
}
