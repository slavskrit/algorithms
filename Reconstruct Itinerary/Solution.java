// https://leetcode.com/problems/reconstruct-itinerary
// 
// Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
// 
// Note:
// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// All airports are represented by three capital letters (IATA code).
// You may assume all tickets form at least one valid itinerary.
// Example 1:
// tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
// Example 2:
// tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
// Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
// 
// Credits:
// Special thanks to @dietpepsi for adding this problem and creating all test cases.
class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            PriorityQueue<String> set = map.getOrDefault(ticket[0], new PriorityQueue<>(String::compareTo));
            set.offer(ticket[1]);
            map.put(ticket[0], set);
        }
        Deque<String> deque = new LinkedList<>();
        deque.push("JFK");
        while (!deque.isEmpty()) {
            String c = deque.peek();
            if (map.get(c) == null || map.get(c).isEmpty()) {
                result.add(c);
                deque.pop();
            } else {
                deque.push(map.get(c).poll());
            }

        }
        Collections.reverse(result);
        return result;
    }
}
