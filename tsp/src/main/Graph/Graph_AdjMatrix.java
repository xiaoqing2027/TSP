package Graph;

/**
 * Created by donghan on 11/23/15.
 */

public class Graph_AdjMatrix extends Graph {

    double[][] matrix;

    public Graph_AdjMatrix(int size) {
        this.size = size;

        matrix = new double[size][size];
        // vertices in the graph are numbered 0, 1, 2 ... n-1 as their identifier.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == j)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = -1.0;
            }
        }
    }

    @Override
    public void addEdge(int from, int to, double distance) {
        matrix[from][to] = distance;
    }

    @Override
    public double getEdge(int from, int to) {
        return matrix[from][to];
    }

    @Override
    public boolean hasEdge(int from, int to) {
        return matrix[from][to] > 0;
    }
}
