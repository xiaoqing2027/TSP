package Graph;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graph_AdjList extends Graph {
    List<GraphVertex> vertices;

    
    class GraphVertex {
        int id;
        Map<Graph_AdjList.GraphVertex, Double> neighbors = new TreeMap<Graph_AdjList.GraphVertex, Double>();
        public GraphVertex(int id) {
            this.id = id;
        }
        public void SetNeighbor(Graph_AdjList.GraphVertex neighbor, double distance) {
            neighbors.put(neighbor, distance);
        }
    }


    public Graph_AdjList(int size) {
        this.size = size;

        vertices = new ArrayList<Graph_AdjList.GraphVertex>(size);
        // vertices in the graph are numbered 0, 1, 2 ... n-1 as their identifier.
        for(int i = 0; i < size; i++) {
            vertices.add(new Graph_AdjList.GraphVertex(i));
        }
    }

    @Override
    public void addEdge(int from, int to, double distance) {
        vertices.get(from).SetNeighbor(vertices.get(to), distance);
    }

    @Override
    public double getEdge(int from, int to) {
        return 0;
    }

    @Override
    public boolean hasEdge(int from, int to) {
        return vertices.get(from).neighbors.containsKey(vertices.get(to));
    }
}
