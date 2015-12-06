package Algorithms;

import Graph.Graph;
import org.junit.*;
import Graph.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TSP_BruteForceTest {
    public final double diff_delta = 1E-5;

    @Test(expected = NotSolvableException.class)
    public void TSP_BF_V3_E2_Directed_Test() throws NotSolvableException {
        Graph g = new Graph_AdjMatrix(true, 3);
        g.addEdge(0,1, 2.0);
        g.addEdge(1,2, 3.0);

        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        test.solve();

    }

    @Test
    public void TSP_BF_V3_E3_Undirected_Test() throws Exception {
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
    @Test
    public void TSP_BF_V6_E30_Directed_Test() throws Exception {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/directedGraph/6_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g,0);
        double result= test.solve();
        String route= test.getShortestRoute();
        assertEquals(result, 80.0, diff_delta);
        assertTrue(route.equals("[0, 1, 5, 4, 3, 2, 0]"));
    }

    @Test
    public void TSP_BF_V11_E110_Directed_Test() throws Exception {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/directedGraph/11_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g,0);
        double result= test.solve();
        String route= test.getShortestRoute();
        assertEquals(result, 187.99106516778, diff_delta);
        assertTrue(route.equals("[0, 5, 3, 8, 7, 1, 2, 6, 4, 10, 9, 0]"));
    }




}