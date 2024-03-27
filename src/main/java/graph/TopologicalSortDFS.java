package graph;

import java.util.LinkedList;
import java.util.List;

public class TopologicalSortDFS {
    public static void topologicalSortDFS(List<Vertex> graph) {
        LinkedList<String> stack = new LinkedList<>();
        for (Vertex vertex : graph) {
            dfs(vertex, stack);
        }
        System.out.println(stack);
    }

    private static void dfs(Vertex vertex, LinkedList<String> stack) {
        if (vertex.status == 2) {
            return;
        }
        if (vertex.status == 1){
            throw new RuntimeException("发现了环");
        }
        vertex.status = 1;
        for (Edge edge : vertex.edges) {
            dfs(edge.linked, stack);
        }
        vertex.status = 2;
        stack.push(vertex.name);
    }
}
