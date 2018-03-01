// https://leetcode.com/problems/course-schedule
// 
// There are a total of n courses you have to take, labeled from 0 to n - 1.
// 
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
// 
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
// 
// For example:
// 
// 2, [[1,0]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
// 
// 2, [[1,0],[0,1]]
// There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
// 
// Note:
// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
// You may assume that there are no duplicate edges in the input prerequisites.
// click to show more hints.
// 
// Hints:
// This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
// Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
// Topological sort could also be done via BFS.
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : prerequisites) {
            Set<Integer> set = graph.getOrDefault(edge[1], new HashSet<>());
            set.add(edge[0]);
            graph.put(edge[1], set);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> picked = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!picked.contains(i)) {
                if (hasLoop(i, graph, visited, picked)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasLoop(int current, HashMap<Integer, Set<Integer>> graph, Set<Integer> visited, Set<Integer> picked) {
        picked.add(current);
        visited.add(current);
        if (graph.containsKey(current)) {
            for (Integer i : graph.get(current)) {
                if (visited.contains(i) || hasLoop(i, graph, visited, picked)) {
                    return true;
                }
            }
        }
        visited.remove(current);
        return false;
    }
}
