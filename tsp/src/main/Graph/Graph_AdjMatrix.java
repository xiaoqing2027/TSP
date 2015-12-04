package Graph;


public class Graph_AdjMatrix extends Graph {

    double[][] matrix;
    boolean isDirected = false;

    public Graph_AdjMatrix(boolean isDirected, int size) {
        this.size = size;
        this.isDirected = isDirected;

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
        if(!isDirected) {
            matrix[to][from] = distance;
        }
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
