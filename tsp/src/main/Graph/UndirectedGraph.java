package Graph;

import java.util.*;


public class UndirectedGraph {
    class UndirectedGraphNode {
        int id;
        Map<UndirectedGraphNode, Double> neighbors = new TreeMap<UndirectedGraphNode, Double>();
        public UndirectedGraphNode(int id) {
            this.id = id;
        }
        public void SetNeighbor(UndirectedGraphNode neighbor, double distance) {
            neighbors.put(neighbor, distance);
        }
    }

    List<UndirectedGraphNode> vertices;

    public UndirectedGraph(int size) {
        vertices = new ArrayList<UndirectedGraphNode>(size);
        // vertices in the graph are numbered 0, 1, 2 ... n-1 as their identifier.
        for(int i = 0; i < size; i++) {
            vertices.add(new UndirectedGraphNode(i));
        }
    }

    public void addEdge(int from, int to, double distance) {
        vertices.get(from).SetNeighbor(vertices.get(to), distance);
        vertices.get(to).SetNeighbor(vertices.get(from), distance);
    }
}
