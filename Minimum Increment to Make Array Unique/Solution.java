// https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/
// 
// Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
// 
// Return the least number of moves to make every value in A unique.
// 
// 
// Example 1:
// 
// Input: [1,2,2]
// Output: 1
// Explanation:  After 1 move, the array could be [1, 2, 3].
// Example 2:
// 
// Input: [3,2,1,2,1,7]
// Output: 6
// Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
// It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
//  
// 
// Note:
// 
// 0 <= A.length <= 40000
// 0 <= A[i] < 40000
class Solution {
    public int minIncrementForUnique(int[] A) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
        	min = Math.min(min, A[i]);
            map.put(A[i], map.getOrDefault(A[i], new ArrayList<>()));
            map.get(A[i]).add(i);
        }
        List<Integer> duplicates =
                map.entrySet()
                        .stream()
                        .filter(e -> e.getValue().size() > 1)
                        .sorted(Comparator.comparingInt(Map.Entry::getKey))
                        .flatMap(e -> e.getValue().stream().skip(1))
                        .collect(Collectors.toList());
        int index = 0;
        for (int i = min; index < duplicates.size(); i++) {
        	if (!map.containsKey(i) && i > A[duplicates.get(index)]) {
        		result += i - A[duplicates.get(index)];
        		index++;
	        }
        }
        return result;
    }
}
