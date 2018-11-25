// https://leetcode.com/problems/knight-dialer/description/
// 
// A chess knight can move as indicated in the chess diagram below:
// 
//  .           
// 
//  
// 
// This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.
// 
// Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.
// 
// How many distinct numbers can you dial in this manner?
// 
// Since the answer may be large, output the answer modulo 10^9 + 7.
// 
//  
// 
// Example 1:
// 
// Input: 1
// Output: 10
// Example 2:
// 
// Input: 2
// Output: 20
// Example 3:
// 
// Input: 3
// Output: 46
//  
// 
// Note:
// 
// 1 <= N <= 5000
class Solution {
    public int knightDialer(int N) {
    Map<Integer, Map<Integer, Long>> cache = new HashMap<>();
    long result = 0;
    int[][] jumps =
        new int[][] {
          {4, 6},
          {6, 8},
          {7, 9},
          {4, 8},
          {3, 0, 9},
          {},
          {0, 1, 7},
          {2, 6},
          {1, 3},
          {4, 2}
        };
    for (int i = 0; i < 10; i++) {
      result += dfs(jumps, N - 1, i, cache);
    }
    return (int) (result % 1000000007);
  }

  private long dfs(int[][] jumps, int n, int current, Map<Integer, Map<Integer, Long>> cache) {
	if (cache.containsKey(n) && cache.get(n).containsKey(current)) return cache.get(n).get(current);
    if (n == 0) return 1;
    long result = 0;
    for (int j = 0; j < jumps[current].length; j++) {
      result += dfs(jumps, n - 1, jumps[current][j], cache) % 1000000007;
    }
    Map<Integer, Long> temp = cache.getOrDefault(n, new HashMap<>());
    temp.put(current, result);
    cache.put(n, temp);
    return result;
  }
}
