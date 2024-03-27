package graph;

import java.util.List;

public class BellmanFord {
    public static void bellmanFord(List<Vertex> graph, Vertex source){
        source.dist = 0;
        int size = graph.size();
        for (int i = 0; i < size - 1; i++) {
            for (Vertex vertex : graph) {
                for (Edge edge : vertex.edges) {
                    Vertex end = edge.linked;
                    if (vertex.dist != Integer.MAX_VALUE && vertex.dist + edge.weight < end.dist){
                        end.dist = vertex.dist + edge.weight;
                        end.prev = vertex;
                    }
                }
            }
        }
    }
}
