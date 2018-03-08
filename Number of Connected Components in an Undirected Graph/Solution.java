// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
// 
// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
// 
// Example 1:
//      0          3
//      |          |
//      1 --- 2    4
// Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
// 
// Example 2:
//      0           4
//      |           |
//      1 --- 2 --- 3
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
// 
// Note:
// You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Set<Integer>[] graph = new HashSet[n];
        for (int[] edge : edges) {
            if (graph[edge[0]] == null) {
                graph[edge[0]] = new HashSet<>();
            }
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new HashSet<>();
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (graph[i] != null && !visited[i]) {
                dfs(i, visited, graph);
                result++;
            }
        }
        for (int i = 0; i < n; i++) if (!visited[i]) result++;
        return result;
    }

    private void dfs(int i, boolean[] visited, Set<Integer>[] graph) {
        if (graph[i] == null || visited[i]) return;
        visited[i] = true;
        for (int n : graph[i]) {
            dfs(n, visited, graph);
        }
    }
}
