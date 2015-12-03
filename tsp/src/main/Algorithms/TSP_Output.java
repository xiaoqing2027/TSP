/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TSP;

import java.io.FileNotFoundException;
import static java.lang.System.out;
import java.util.Arrays;

/**
 *
 * @author miaodonghan
 */
public class TSP_Output {
    public static void main(String[] args) throws FileNotFoundException{
        UndirectedGraph g;
        
        GraphTextDeserializer gReader = new GraphTextDeserializer();

        g = gReader.load("./data/5.txt");

        TSP_DP tsp_dp = new TSP_DP(g);
        System.out.println(" "+ Arrays.toString(tsp_dp.computeRoutes(g)));
//        TSPAlgorithm_BruteForce tsp_bf = new TSPAlgorithm_BruteForce(g,0);

//        System.out.println(" "+ tsp_bf.solve());

    }
}
