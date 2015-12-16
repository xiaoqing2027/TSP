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
//        g.addEdge(0, 1, 2.0);
//        g.addEdge(1, 2, 3.0);
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
//        g.addEdge(0, 1, 2.0);
//        g.addEdge(1, 2, 3.0);
//        g.addEdge(0, 2, 4.0);
//
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//
//        assertTrue(result == 9.0);
//        assertTrue(test.getShortestRoute().equals("[0, 1, 2, 0]"));

//    }

//    @Test
//    public void TSP_DP_V4_E12_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/4_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 88.80365335258, diff_delta);
//        assertTrue(route.equals("[0, 3, 2, 1, 0]"));
//
//    }
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

    @Test
    public void TSP_DP_V7_E42_Directed_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;
        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/directedGraph/7_d.txt");
        TSP_DP test = new TSP_DP(g);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result, 148.23749344215, diff_delta);
        assertTrue(route.equals("[0, 5, 3, 1, 4, 2, 6, 0]"));

    }

//    @Test
//    public void TSP_DP_V8_E56_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/8_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 132.91130313333002, diff_delta);
//        assertTrue(route.equals("[0, 3, 6, 5, 4, 7, 1, 2, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V9_E72_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/9_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 170.66431992512, diff_delta);
//        assertTrue(route.equals("[0, 7, 4, 5, 6, 8, 1, 3, 2, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V10_E90_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/10_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 176.21878305910002, diff_delta);
//        assertTrue(route.equals("[0, 4, 6, 9, 1, 5, 8, 2, 7, 3, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V11_E110_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/11_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 187.99106516778, diff_delta);
//        assertTrue(route.equals("[0, 5, 3, 8, 7, 1, 2, 6, 4, 10, 9, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V12_E132_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/12_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 185.11286376610002, diff_delta);
//        assertTrue(route.equals("[0, 2, 6, 4, 1, 5, 11, 7, 8, 9, 3, 10, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V13_E156_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/13_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 126.39240779262, diff_delta);
//        assertTrue(route.equals("[0, 1, 3, 11, 7, 8, 2, 10, 6, 4, 9, 5, 12, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V14_E182_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/14_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 200.12742101279002, diff_delta);
//        assertTrue(route.equals("[0, 7, 9, 3, 1, 12, 8, 5, 13, 4, 11, 2, 10, 6, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V15_E210_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/15_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 197.2107028676, diff_delta);
//        assertTrue(route.equals("[0, 3, 9, 2, 6, 12, 7, 13, 8, 1, 10, 11, 14, 5, 4, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V16_E240_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/16_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 198.78257458810003, diff_delta);
//        assertTrue(route.equals("[0, 12, 6, 11, 9, 14, 10, 5, 15, 7, 4, 8, 3, 1, 13, 2, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V17_E272_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/17_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 124.67374864703001, diff_delta);
//        assertTrue(route.equals("[0, 9, 16, 6, 12, 1, 4, 3, 2, 7, 5, 14, 15, 13, 10, 8, 11, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V18_E306_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/18_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//
//        assertEquals(result, 161.09434175068, diff_delta);
//        assertTrue(route.equals("[0, 9, 11, 3, 4, 8, 7, 17, 14, 2, 16, 12, 13, 5, 15, 1, 6, 10, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V19_E342_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/19_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 187.84366564072002, diff_delta);
//        assertTrue(route.equals("[0, 17, 5, 14, 8, 18, 15, 1, 16, 11, 7, 4, 12, 9, 13, 3, 6, 2, 10, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V20_E380_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/20_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 143.28007839280997, diff_delta);
//        assertTrue(route.equals("[0, 17, 18, 14, 2, 12, 3, 11, 15, 8, 1, 19, 4, 16, 13, 9, 7, 5, 6, 10, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V21_E420_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/21_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 168.58931808531997, diff_delta);
//        assertTrue(route.equals("[0, 8, 15, 16, 19, 20, 7, 1, 2, 4, 6, 14, 18, 13, 17, 12, 5, 10, 11, 9, 3, 0]"));
//
//    }
//
//    @Test
//    public void TSP_DP_V22_E462_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./completeGraph/directedGraph/22_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 190.42906319352, diff_delta);
//        assertTrue(route.equals("[0, 21, 18, 19, 9, 2, 10, 6, 4, 13, 7, 14, 17, 5, 8, 15, 11, 12, 20, 1, 3, 16, 0]"));
//
//    }

//    cannot stand 23 vertices, running 23 vertices takes too long and too much RAM
//
//    -----------------------directed incomplete graph test ------------------------------

//    @Test
//    public void TSP_DP_V8_E41_Directed_Test() throws NotSolvableException, FileNotFoundException {
//        Graph g;
//
//        GraphTextDeserializer gReader = new GraphTextDeserializer();
//        g = gReader.load("./incompleteGraph/8_d.txt");
//        TSP_DP test = new TSP_DP(g);
//        double result = test.solve();
//        String route = test.getShortestRoute();
//        assertEquals(result, 124.78312518185999, diff_delta);
//        assertTrue(route.equals("[0, 7, 1, 3, 4, 2, 6, 5, 0]"));
//
//    }
}