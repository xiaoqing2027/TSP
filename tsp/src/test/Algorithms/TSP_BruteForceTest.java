package Algorithms;

import Graph.Graph;
import org.junit.*;
import Graph.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by donghan on 12/5/15.
 */
public class TSP_BruteForceTest {

    @Test
    public void TSP_BruteForce_Undirected_complete_Test() throws Exception {
        Graph g = new Graph_AdjMatrix(false, 3);
        g.addEdge(0,1, 2.0);
        g.addEdge(1,2, 3.0);
        g.addEdge(0,2, 4.0);

        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertTrue(result == 9.0);
        assertTrue(route.equals("[0, 1, 2, 0]"));

    }

    @Test(expected = NotSolvableException.class)
    public void TSP_BruteForce_Directed_incompleteTest() throws NotSolvableException {
        Graph g = new Graph_AdjMatrix(true, 3);
        g.addEdge(0,1, 2.0);
        g.addEdge(1,2, 3.0);

        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        test.solve();

    }
}