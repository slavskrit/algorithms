// https://leetcode.com/problems/graph-valid-tree
// 
// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
// 
// For example:
// 
// Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
// 
// Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
// 
// Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new HashSet<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        if (isCycle(0, visited, graph)) {
            return false;
        }
        for (int i = 0; i < n; i++) if (!visited[i]) return false;
        return true;
    }

    private boolean isCycle(int i, boolean[] visited, Map<Integer, Set<Integer>> graph) {
        if (visited[i]) return true;
        visited[i] = true;
        for (int n : graph.get(i)) {
            graph.get(n).remove(i);
            if (isCycle(n, visited, graph)) {
                return true;
            }
        }
        return false;
    }
}
