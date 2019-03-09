import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created on 18 Nov 2018 by happygirlzt
 *
 * LeetCode #332. Reconstruct Itinerary
 *
 */

public class ReconstructItinerary {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> res = new LinkedList<>();

        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }

        dfs("JFK", flights, res);
        return res;
    }

    public void dfs(String dep, Map<String, PriorityQueue<String>> flights, LinkedList<String> res) {
        PriorityQueue<String> arrivals = flights.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, res);
        }

        res.addFirst(dep);
    }

    // Updated on 9 Feb 2019
    public List<String> findItinerary1(String[][] tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String[] travel: tickets) {
            String out = travel[0], in = travel[1];
            graph.putIfAbsent(out, new PriorityQueue<>());
            graph.get(out).add(in);
        }

        dfs("JFK", graph, res);
        return res;
    }

    private void dfs(String out, Map<String, PriorityQueue<String>> graph, List<String> res) {
        PriorityQueue<String> ins = graph.get(out);
        while (ins != null && !ins.isEmpty()) {
            dfs(ins.poll(), graph, res);
        }
        res.add(0, out);
    }

    // Updated on 9 Mar 2019
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> g = new HashMap<>();
        buildGraph(g, tickets);
        dfs(g, "JFK", res);
        return res;
    }

    private void dfs(Map<String, PriorityQueue<String>> g, String from, LinkedList<String> res) {
        PriorityQueue<String> arrivals = g.get(from);
        while (arrivals != null && !arrivals.isEmpty()) {
            String to = arrivals.poll();
            dfs(g, to, res);

        }
        res.addFirst(from);
    }

    private void buildGraph(Map<String, PriorityQueue<String>> g, String[][] tickets) {
        for (String[] travel : tickets) {
            String from = travel[0];
            String to = travel[1];
            g.putIfAbsent(from, new PriorityQueue<>());
            g.get(from).offer(to);
        }
    }
}
