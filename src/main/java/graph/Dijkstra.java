package graph;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {
    public static void dijkstra(List<Vertex> graph, Vertex source){
        ArrayList<Vertex> list = new ArrayList<>(graph);
        source.dist = 0;
        while (!list.isEmpty()){
            Vertex curr = chooseMinDistVertex(list);
            updateNeighbourDist(curr, list);
            list.remove(curr);
            curr.visited = true;
        }
    }

    private static void updateNeighbourDist(Vertex curr, ArrayList<Vertex> list) {
        for (Edge edge : curr.edges) {
            Vertex n = edge.linked;
            if (list.contains(n)){
                int dist = curr.dist + edge.weight;
                if (dist < n.dist){
                    n.dist = dist;
                    n.prev = curr;
                }
            }
        }
    }

    private static Vertex chooseMinDistVertex(ArrayList<Vertex> list) {
        Vertex min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).dist < min.dist){
                min = list.get(i);
            }
        }
        return min;
    }
}
