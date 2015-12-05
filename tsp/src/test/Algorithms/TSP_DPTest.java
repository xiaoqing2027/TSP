package Algorithms;

import Graph.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by donghan on 12/5/15.
 */
public class TSP_DPTest {

    @Test
    public void TSP_DP_Undirected_complete_Test() throws Exception {

        Graph g = new Graph_AdjMatrix(false, 3);
        g.addEdge(0,1, 2.0);
        g.addEdge(1,2, 3.0);
        g.addEdge(0,2, 4.0);

        TSP_DP test = new TSP_DP(g);
        double result = test.solve();

        assertTrue(result == 9.0);
    }

    @Test(expected = NotSolvableException.class)
    public void TSP_DP_Directed_incompleteTest() throws NotSolvableException {
        Graph g = new Graph_AdjMatrix(true, 3);
        g.addEdge(0,1, 2.0);
        g.addEdge(1,2, 3.0);

        TSP_DP test = new TSP_DP(g);
        System.out.println(test.solve());


    }
}