package Graph;


public abstract class Graph {
    protected int size;
    public int getsize() {
        return size;
    }
    public abstract void addEdge(int from, int to, double distance);
    public abstract double getEdge(int from, int to);
    public abstract boolean hasEdge(int from, int to);

}
