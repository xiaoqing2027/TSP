package Graph;


public abstract class Graph {
    protected int size;
    //number of vertices
    public int getsize() {
        return size;
    }
    public abstract void addEdge(int from, int to, double distance);
    public abstract double getEdge(int from, int to);
    //check if there has edge between vertex from and to
    public abstract boolean hasEdge(int from, int to);

}
