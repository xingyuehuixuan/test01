package graph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraPriorityQueue {
    public static void dijkstra(List<Vertex> graph, Vertex source){
        PriorityQueue<Vertex> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v.dist));
        source.dist = 0;
        for (Vertex vertex : graph) {
            queue.offer(vertex);
        }
        while (!queue.isEmpty()){
            Vertex curr = queue.peek();
            if (!curr.visited) {
                updateNeighbourDist(curr, queue);
                curr.visited = true;
            }
            queue.poll();
        }
    }

    private static void updateNeighbourDist(Vertex curr, PriorityQueue<Vertex> queue) {
        for (Edge edge : curr.edges) {
            Vertex n = edge.linked;
            if (!n.visited){
                int dist = curr.dist + edge.weight;
                if (dist < n.dist){
                    n.dist = dist;
                    n.prev = curr;
                    queue.offer(n);
                }
            }
        }
    }
}
