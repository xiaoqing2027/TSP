package Algorithms;

import Graph.Graph;
import org.junit.*;
import Graph.*;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TSP_BruteForceTest {
    public final double diff_delta = 1E-5;

    @Test(expected = NotSolvableException.class)
    public void TSP_BF_V3_E2_Directed_Test() throws NotSolvableException {
        Graph g = new Graph_AdjMatrix(true, 3);
        g.addEdge(0, 1, 2.0);
        g.addEdge(1, 2, 3.0);

        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        test.solve();

    }

    @Test
    public void TSP_BF_V3_E3_Undirected_Test() throws Exception {
        Graph g = new Graph_AdjMatrix(false, 3);
        g.addEdge(0, 1, 2.0);
        g.addEdge(1, 2, 3.0);
        g.addEdge(0, 2, 4.0);

        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertTrue(result == 9.0);
        assertTrue(route.equals("[0, 1, 2, 0]"));

    }
@Test
public void TSP_DP_V4_E12_Directed_Test() throws NotSolvableException, FileNotFoundException {
    Graph g;

    GraphTextDeserializer gReader = new GraphTextDeserializer();
    g = gReader.load("./completeGraph/directedGraph/4_d.txt");
    TSP_BruteForce test = new TSP_BruteForce(g, 0);
    double result = test.solve();
    String route = test.getShortestRoute();
    assertEquals(result,88.80365335258, diff_delta);
    assertTrue(route.equals("[0, 3, 2, 1, 0]"));

}

@Test
public void TSP_DP_V5_E20_Directed_Test() throws NotSolvableException, FileNotFoundException {
    Graph g;

    GraphTextDeserializer gReader = new GraphTextDeserializer();
    g = gReader.load("./completeGraph/directedGraph/5_d.txt");
    TSP_BruteForce test = new TSP_BruteForce(g, 0);
    double result = test.solve();
    String route = test.getShortestRoute();
    assertEquals(result,181.6441036506, diff_delta);
    assertTrue(route.equals("[0, 3, 2, 1, 4, 0]"));

}

    @Test
    public void TSP_BF_V6_E30_Directed_Test() throws Exception {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/directedGraph/6_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result, 80.0, diff_delta);
        assertTrue(route.equals("[0, 1, 5, 4, 3, 2, 0]"));
    }


@Test
public void TSP_DP_V7_E42_Directed_Test() throws NotSolvableException, FileNotFoundException {
    Graph g;

    GraphTextDeserializer gReader = new GraphTextDeserializer();
    g = gReader.load("./completeGraph/directedGraph/7_d.txt");
    TSP_BruteForce test = new TSP_BruteForce(g, 0);
    double result = test.solve();
    String route = test.getShortestRoute();
    assertEquals(result,148.23749344215, diff_delta);
    assertTrue(route.equals("[0, 5, 3, 1, 4, 2, 6, 0]"));

}
@Test
public void TSP_DP_V8_E56_Directed_Test() throws NotSolvableException, FileNotFoundException {
    Graph g;

    GraphTextDeserializer gReader = new GraphTextDeserializer();
    g = gReader.load("./completeGraph/directedGraph/8_d.txt");
    TSP_BruteForce test = new TSP_BruteForce(g, 0);
    double result = test.solve();
    String route = test.getShortestRoute();
    assertEquals(result,132.91130313333, diff_delta);
    assertTrue(route.equals("[0, 3, 6, 5, 4, 7, 1, 2, 0]"));

}
@Test
public void TSP_DP_V9_E72_Directed_Test() throws NotSolvableException, FileNotFoundException {
    Graph g;

    GraphTextDeserializer gReader = new GraphTextDeserializer();
    g = gReader.load("./completeGraph/directedGraph/9_d.txt");
    TSP_BruteForce test = new TSP_BruteForce(g, 0);
    double result = test.solve();
    String route = test.getShortestRoute();
        assertEquals(result, 170.66431992512, diff_delta);
        assertTrue(route.equals("[0, 7, 4, 5, 6, 8, 1, 3, 2, 0]"));

}
    @Test
    public void TSP_DP_V10_E90_Directed_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/directedGraph/10_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result, 176.21878305910002, diff_delta);
        assertTrue(route.equals("[0, 4, 6, 9, 1, 5, 8, 2, 7, 3, 0]"));

    }

    @Test
    public void TSP_BF_V11_E110_Directed_Test() throws Exception {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/directedGraph/11_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result, 187.99106516778, diff_delta);
        assertTrue(route.equals("[0, 5, 3, 8, 7, 1, 2, 6, 4, 10, 9, 0]"));
    }


    //------------------------undirected Complete graph test---------------------

        // 5 vertices /undirected graph
    @Test
    public void TSP_DP_V5_E10_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/undirectedGraph/5_un.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result,50.33620852873, diff_delta);
        assertTrue(route.equals("[0, 1, 3, 4, 2, 0]"));

    }

    // 7 vertices /undirected graph
    @Test
    public void TSP_DP_V7_E21_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/undirectedGraph/7_un.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result,207.07141717529998, diff_delta);
        assertTrue(route.equals("[0, 4, 2, 1, 5, 3, 6, 0]"));

    }

    // 8 vertices /undirected graph
    @Test
    public void TSP_DP_V8_E28_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./completeGraph/undirectedGraph/8_un.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result,138.55409381008002, diff_delta);
        assertTrue(route.equals("[0, 5, 2, 3, 1, 4, 7, 6, 0]"));

    }

    //------------------------directed inComplete graph test---------------------
    // 8 vertices /undirected graph
    @Test
    public void TSP_DP_V8_E41_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./incompleteGraph/8_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result,124.78312518186, diff_delta);
        assertTrue(route.equals("[0, 7, 1, 3, 4, 2, 6, 5, 0]"));

    }
    // 10 vertices /undirected graph
    @Test
    public void TSP_DP_V10_E67_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./incompleteGraph/10_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result,286.12278708017004, diff_delta);
        assertTrue(route.equals("[0, 3, 6, 7, 8, 2, 4, 1, 9, 5, 0]"));

    }

    // 12 vertices /undirected graph
    @Test
    public void TSP_DP_V12_E106_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./incompleteGraph/12_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result,161.00328166354998, diff_delta);
        assertTrue(route.equals("[0, 8, 2, 1, 7, 5, 3, 9, 6, 10, 4, 11, 0]"));

    }

    // 13 vertices /undirected graph
    @Test
    public void TSP_DP_V13_E102_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./incompleteGraph/13_d.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result,282.26534313268996, diff_delta);
        assertTrue(route.equals("[0, 4, 12, 5, 10, 3, 1, 11, 9, 6, 7, 2, 8, 0]"));

    }

    // 13 vertices /undirected graph
    @Test
    public void TSP_DP_V13_E109_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./incompleteGraph/13_d_0.7.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
        assertEquals(result,213.35338894241997, diff_delta);
        assertTrue(route.equals("[0, 2, 12, 10, 11, 4, 3, 6, 8, 7, 5, 9, 1, 0]"));

    }

    // 13 vertices /undirected graph
    @Test
    public void TSP_DP_V13_E128_Undirected_Test() throws NotSolvableException, FileNotFoundException {
        Graph g;

        GraphTextDeserializer gReader = new GraphTextDeserializer();
        g = gReader.load("./incompleteGraph/13_d_0.8.txt");
        TSP_BruteForce test = new TSP_BruteForce(g, 0);
        double result = test.solve();
        String route = test.getShortestRoute();
//        assertEquals(result,282.26534313268996, diff_delta);
//        assertTrue(route.equals("[0, 4, 12, 5, 10, 3, 1, 11, 9, 6, 7, 2, 8, 0]"));

    }

}