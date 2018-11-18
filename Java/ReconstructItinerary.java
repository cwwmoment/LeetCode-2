/**
 * Created on 18 Nov 2018 by happygirlzt
 *
 * LeetCode #332. Reconstruct Itinerary
 *
 */

public class ReconstructItinerary {
    HashMap<String, PriorityQueue<String>> flights;
    LinkedList<String> res;

    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        res = new LinkedList<>();

        for (String[] ticket : tickets) {
            flights.putIfAbsent(ticket[0], new PriorityQueue<>());
            flights.get(ticket[0]).add(ticket[1]);
        }

        dfs("JFK");
        return res;
    }

    public void dfs(String dep) {
        PriorityQueue<String> arrivals = flights.get(dep);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }

        res.addFirst(dep);
    }
}
