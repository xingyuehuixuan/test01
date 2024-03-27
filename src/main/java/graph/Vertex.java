package graph;

import java.util.List;
import java.util.Objects;

public class Vertex {
    String name;
    List<Edge> edges;
    boolean visited;
    int inDegree;
    int status;
    int dist = INF;
    static final Integer INF = Integer.MAX_VALUE;
    Vertex prev = null;

    public Vertex(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return Objects.equals(name, vertex.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
