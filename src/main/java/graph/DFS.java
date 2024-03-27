package graph;

import java.util.LinkedList;

public class DFS {
    private static void dfs(Vertex v){
        v.visited = true;
        System.out.println(v.name);
        for (Edge edge : v.edges) {
            if (!edge.linked.visited){
                dfs(edge.linked);
            }
        }
    }

    private static void dfs2(Vertex v){
        LinkedList<Vertex> stack = new LinkedList<>();
        stack.push(v);
        while (!stack.isEmpty()){
            Vertex pop = stack.pop();
            pop.visited = true;
            System.out.println(pop.name);
            for (Edge edge : pop.edges) {
                if (!edge.linked.visited){
                    stack.push(edge.linked);
                }
            }
        }
    }
}
