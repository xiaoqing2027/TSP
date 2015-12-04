/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Arrays;


public class TSP_Output {

    public static void main(String[] args) throws FileNotFoundException {
        Graph g;

        DirectedGraphTextDeserializer gReader = new DirectedGraphTextDeserializer();

        g = gReader.load("./data/6.txt");

        TSP_DP tsp_dp = new TSP_DP(g);
        tsp_dp.computeRoutes(g);

//        TSPAlgorithm_BruteForce tsp_bf = new TSPAlgorithm_BruteForce(g,0);
//        System.out.println(" "+ tsp_bf.solve());
    }
}
