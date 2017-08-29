// https://leetcode.com/problems/triangle
// 
// Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
// 
// For example, given the following triangle
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
// ]
// 
// The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
// 
// Note:
// Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> current = triangle.get(i);
            current.set(0, current.get(0) + triangle.get(i - 1).get(0)); // set left border
            current.set(current.size() - 1, current.get(current.size() - 1) + triangle.get(i - 1).get(triangle.get(i - 1).size() - 1)); // set right border
            for (int j = 1; j < current.size() - 1; j++) {
                int temp = current.get(j);
                current.set(j, Math.min(triangle.get(i - 1).get(j - 1) + current.get(j), triangle.get(i - 1).get(j) + current.get(j)));
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
