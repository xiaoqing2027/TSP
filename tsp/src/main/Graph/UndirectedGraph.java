package Graph;

import java.util.*;


public abstract class UndirectedGraph {
    protected int size;
    public int getsize() {
        return size;
    }
    public abstract void addEdge(int from, int to, double distance);
    public abstract double getEdge(int from, int to);

}
