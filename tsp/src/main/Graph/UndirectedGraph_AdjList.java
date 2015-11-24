package Graph;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class UndirectedGraph_AdjList extends UndirectedGraph {
    class UndirectedGraphVertex {
        int id;
        Map<UndirectedGraphVertex, Double> neighbors = new TreeMap<UndirectedGraphVertex, Double>();
        public UndirectedGraphVertex(int id) {
            this.id = id;
        }
        public void SetNeighbor(UndirectedGraphVertex neighbor, double distance) {
            neighbors.put(neighbor, distance);
        }
    }

    List<UndirectedGraphVertex> vertices;

    public UndirectedGraph_AdjList(int size) {
        this.size = size;

        vertices = new ArrayList<UndirectedGraphVertex>(size);
        // vertices in the graph are numbered 0, 1, 2 ... n-1 as their identifier.
        for(int i = 0; i < size; i++) {
            vertices.add(new UndirectedGraphVertex(i));
        }
    }

    @Override
    public void addEdge(int from, int to, double distance) {
        vertices.get(from).SetNeighbor(vertices.get(to), distance);
        vertices.get(to).SetNeighbor(vertices.get(from), distance);
    }

    @Override
    public double getEdge(int from, int to) {
        return 0;
    }
}
