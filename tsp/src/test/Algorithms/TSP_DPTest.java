package Algorithms;

import Graph.*;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.*;



public class TSP_DPTest {
    private static Logger log = Logger.getLogger(TSP_DPTest.class);
    public final double diff_delta = 1E-5;
//    @Test(expected = NotSolvableException.class)
//    public void TSP_DP_V3_E2_Directed_NotSolvable_Test() throws NotSolvableException {
//        Graph g = new Graph_AdjMatrix(true, 3);
//        g.addEdge(0,1, 2.0);
//        g.addEdge(1,2, 3.0);
//
//        TSP_DP test = new TSP_DP(g);
//        System.out.println(test.solve());
//
//    }
//
//    @Test
//    public void TSP_DP_V3_E3_Undirected_Test() throws Exception {
//
//        Graph g = new Graph_AdjMatrix(false, 3);
//        g.addEdge(0,1, 2.0);
//        g.addEdge(1,2, 3.0);
//        g.addEdge(0,2, 4.0);
//
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//
//        assertTrue(result == 9.0);
//        assertTrue(test.getShortestRoute().equals("[0, 1, 2, 0]"));
//
//    }
//
//
//    @Test
//    public void TSP_DP_V6_E30_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/6_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 80.0, diff_delta);
//        assertTrue(route.equals("[0, 1, 5, 4, 3, 2, 0]"));
//
//    }
//    @Test
//    public void TSP_DP_V11_E110_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/11_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result= test.solve();
//        String route= test.getShortestRoute();
//        assertEquals(result, 187.99106516778, diff_delta);
//        assertTrue(route.equals("[0, 5, 3, 8, 7, 1, 2, 6, 4, 10, 9, 0]"));
//
//    }

    @Test
    public void TSP_DP_V22_E462_Directed_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;
        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/directedGraph/22_d.txt");
        TSP_DP test = new TSP_DP(g);
        double result= test.solve();
        String route= test.getShortestRoute();
//        System.out.println("result: "+result);
//        System.out.println("route: "+route);
        assertEquals(result, 190.42906319352, diff_delta);
        assertTrue(route.equals("[0, 21, 18, 19, 9, 2, 10, 6, 4, 13, 7, 14, 17, 5, 8, 15, 11, 12, 20, 1, 3, 16, 0]"));

    }

    
}